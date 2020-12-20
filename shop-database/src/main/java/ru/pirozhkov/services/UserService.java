package ru.pirozhkov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pirozhkov.entities.User;
import ru.pirozhkov.repositories.UserRepository;

import java.util.List;

@Service("userService")
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Transactional(readOnly = true)
    public User get(Long id) {
        return userRepository.getOne(id);
    }


    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }


    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }


    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }


}
