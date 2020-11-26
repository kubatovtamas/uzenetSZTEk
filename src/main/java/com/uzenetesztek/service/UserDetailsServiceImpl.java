package com.uzenetesztek.service;

import com.uzenetesztek.domain.User;
import com.uzenetesztek.domain.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;
    private EmailService emailService;

    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

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

    public void userActivation(String code){
        User user = userService.findByActivation(code);
        if(!Objects.isNull(user)){
            user.setEnabled(true);
            user.setActivation("");
            userService.save(user);
        }else{
            //TODO: what if the activation code isn't exist
        }
    }

    public void registerUser(User user){
        user.setEnabled(false);
        user.setActivation(generateKey());
        user.setAuthority("ROLE_USER");
        userService.save(user);//It throw an exception if the user already exist
        emailService.sendMessage(user.getEmail(), user.getFirstName(), user.getActivation()); //activation code send to user
    }

    //a 16-length activation code
    public String generateKey(){
        Random random = new Random();
        char[] word = new char[16];
        for(int i=0;i< word.length;++i){
            word[i] = (char) ('a'+random.nextInt(26));
        }
        return new String(word);
    }
}
