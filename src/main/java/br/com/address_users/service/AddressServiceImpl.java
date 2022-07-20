package br.com.address_users.service;

import br.com.address_users.model.Address;
import br.com.address_users.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address create(Address address) throws Exception {
        try{
            return addressRepository.save(address);
        } catch (Exception e){
            throw new Exception("Ocorreu um erro ao salvar o usuário. " + e.getMessage());
        }
    }

    @Override
    public List<Address> findByUserId(Long userId) {
        return addressRepository.findByUserId(userId);
    }

    @Override
    public void updateAddessAsMain(Long userId, Long addressId) throws Exception {
        try {
            List<Address> addresses = addressRepository.findByUserId(userId);
            addresses.forEach(a -> a.setMain(addressId == a.getId()));
            addressRepository.saveAll(addresses);
        } catch (Exception e){
            throw new Exception("Ocorreu um erro ao alterar o endereço. " + e.getMessage());
        }
    }

}
