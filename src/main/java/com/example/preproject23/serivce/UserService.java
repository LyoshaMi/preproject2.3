package com.example.preproject23.serivce;

import com.example.preproject23.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    public List<User> getAllUsers();

    public User getUser(Long id);

    public void addUser(User user);

    public void deleteUser(Long id);

}
