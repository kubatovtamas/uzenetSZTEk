package com.uzenetesztek.service;

import com.uzenetesztek.domain.User;
import com.uzenetesztek.domain.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserServiceImpl userServiceImpl;
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    private EmailService emailService;
    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    private PasswordEncoder passwordEncoder;
    @Autowired
    public void setUserService(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }



    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User entity = userServiceImpl.getByEmail(userEmail);

        return new UserDetailsImpl(entity);
    }

    /**
     * TODO
     * @param code
     * @return
     */
    public String userActivation(String code){
        User user = userServiceImpl.getByActivationCode(code);

        if (!Objects.isNull(user)) {
            user.setEnabled(true);
            user.setActivationCode("");
            userServiceImpl.save(user);

            return "ok";
        } else {
            return "error";
        }
    }

    /**
     * TODO
     * @param user
     * @return
     */
    public String registerUser(User user) {
        try {
            user.setEnabled(false);
            user.setActivationCode(generateKey());
            user.setAuthority("ROLE_USER");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setProfilePicture("https://robohash.org/remuttenetur.bmp?size=50x50&set=set1");
            userServiceImpl.save(user);  // It throws an exception if the user already exists
            emailService.sendMessage(user.getEmail(), user.getFirstName(), user.getActivationCode());  // activation code send to user
            return "ok";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     *
     * @return 16-Length Activation Code
     */
    public String generateKey(){
        Random random = new Random();
        char[] word = new char[16];
        for(int i = 0; i< word.length; ++i) {
            word[i] = (char) ('a' + random.nextInt(26));
        }
        return new String(word);
    }
}
