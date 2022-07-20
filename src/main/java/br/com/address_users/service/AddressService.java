package br.com.address_users.service;

import br.com.address_users.model.Address;

import java.util.List;

public interface AddressService {

    public Address create(Address address) throws Exception;
    public List<Address> findByUserId(Long userId);
    public void updateAddessAsMain(Long userId, Long addressId) throws Exception;
}
