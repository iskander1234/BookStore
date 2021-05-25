package com.example.demo.security;


import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@Service
public class CurrentUserFinder {

    @Autowired
    UserService usService;

    public long getCurrentUserId() {
        UserDetails details = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = details.getUsername();
        long userId = -1;
        for (User user : usService.findAll()) {
            if (user.getUserName().equals(username)) {
                userId = user.getUserId();
                break;
            }
        }
        return userId;
    }

    public User getCurrentUser() {
        User currentUser = usService.findById(getCurrentUserId());
        return currentUser;
    }
}
