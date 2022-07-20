package br.com.address_users.service;

import br.com.address_users.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> findAll();
    public Optional<User> findById(Long id);
    public User create(User user) throws Exception;
    public User update(User user, Long id) throws Exception;
    public void deleteById(Long id) throws Exception;
}
