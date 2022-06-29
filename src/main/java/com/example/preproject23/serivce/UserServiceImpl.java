package com.example.preproject23.serivce;

import com.example.preproject23.dao.UserRepository;
import com.example.preproject23.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        User user = null;
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            user = userOptional.get();
        }
        return user;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
