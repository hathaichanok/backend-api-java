package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.user.entity.User;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(id));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User patchUser(Long id, User partialUser) {

        User existingUser = userRepository.findById(id)
                            .orElseThrow(() -> new NotFoundException(id));
    
        if (partialUser.getName() != null) {
            existingUser.setName(partialUser.getName());
        }
        if (partialUser.getPhone() != null) {
            existingUser.setPhone(partialUser.getPhone());
        }
        if (partialUser.getUsername() != null) {
            existingUser.setUsername(partialUser.getUsername());
        }
        if (partialUser.getWebsite() != null) {
            existingUser.setWebsite(partialUser.getWebsite());
        }
        if (partialUser.getAddress() != null) {
            existingUser.setAddress(partialUser.getAddress());
        }
        if (partialUser.getCompany() != null) {
            existingUser.setCompany(partialUser.getCompany());
        }

        return userRepository.save(existingUser);
    }
}

