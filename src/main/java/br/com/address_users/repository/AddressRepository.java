package br.com.address_users.repository;

import br.com.address_users.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    public List<Address> findByUserId(Long userId);

}
