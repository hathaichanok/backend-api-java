package com.example.demo.services;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public Page<User> listUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(id));
    }

    public User createUser(User user) throws BadRequestException {
        if(userRepository.findByEmail(user.getEmail()) != null){
            // email already exist
            throw new BadRequestException("Email " + user.getEmail() + " already existed");
        }
        
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

