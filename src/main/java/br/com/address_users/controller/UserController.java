package br.com.address_users.controller;

import br.com.address_users.model.Address;
import br.com.address_users.model.User;
import br.com.address_users.service.AddressServiceImpl;
import br.com.address_users.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "http://address.users.com.br")
public class UserController {

    @Autowired
    UserServiceImp userService;

    @Autowired
    AddressServiceImpl addressService;

    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<User>> read(@PathVariable Long id){
        Optional<User> foundUser = userService.findById(id);
        if (foundUser.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundUser);
        }
    }

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> readAll(){
        List<User> allUsers = userService.findAll();
        if(allUsers.size() == 0){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(allUsers);
        }
    }

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> create(@RequestBody User user){
        try{
            User createdUser = userService.create(user);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/user/{id}")
                    .buildAndExpand(createdUser.getId())
                    .toUri();
            return ResponseEntity.created(uri).body(createdUser);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @PutMapping(value = "/user/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id){
        try {
            User updatedUser = userService.update(user, id);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @PutMapping(value = "/user/{userId}/address")
    public ResponseEntity<Optional<User>>createAddress(@RequestBody Address address, @PathVariable Long userId){
        try{
            Optional<User> updatedUser = userService.findById(userId);
            if (updatedUser.isEmpty()){
                return ResponseEntity.notFound().build();
            } else {
                address.setUser(updatedUser.get());
                addressService.create(address);
                return ResponseEntity.ok(userService.findById(userId));
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping(value = "/user/{userId}/mainAddress/{addressId}")
    public ResponseEntity<Optional<User>>updateAddressAsMain(
            @PathVariable Long userId,
            @PathVariable Long addressId
    ){
        try{
           Optional<User> updateUser = userService.findById(userId);
           if(updateUser.isEmpty()){
               return ResponseEntity.notFound().build();
           } else {
                addressService.updateAddessAsMain(userId, addressId);
                return ResponseEntity.ok(updateUser = userService.findById(userId));
           }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        try{
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
}
