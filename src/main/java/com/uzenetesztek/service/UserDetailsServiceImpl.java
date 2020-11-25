package com.uzenetesztek.service;

import com.uzenetesztek.domain.User;
import com.uzenetesztek.domain.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
//        Optional<User> entity = userService.findByEmail(userEmail);
//        entity.map(UserDetailsService::new).get();

        User entity = userService.getByEmail(userEmail);
        return new UserDetailsImpl(entity);
    }
}
