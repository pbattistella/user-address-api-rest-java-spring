package br.com.address_users.service;

import br.com.address_users.model.Address;
import br.com.address_users.model.User;
import br.com.address_users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User create(User user) throws Exception {
        try{
            return userRepository.save(user);
        } catch (Exception e){
            throw new Exception("Ocorreu um erro ao salvar o usuário. " + e.getMessage());
        }
    }

    @Override
    public User update(User user, Long id) throws Exception {
        Optional<User> userUpdated = userRepository.findById(id);
        if (userUpdated.isEmpty()){
            throw new Exception("Usuário não existe");
        }

        userUpdated.get().setName(user.getName());
        userUpdated.get().setBirthDate(user.getBirthDate());
        return userRepository.save(userUpdated.get());
    }

    @Override
    public void deleteById(Long id) throws Exception{
        try{
            userRepository.deleteById(id);
        } catch (Exception e){
            throw new Exception("Erro ao deletar o usuário");
        }

    }
}
