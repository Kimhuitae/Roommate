package com.Project.Roommate.Service;

import com.Project.Roommate.Entity.User;
import com.Project.Roommate.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class userservice {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    private AuthenticationManager authenticationManager;
//
    @Transactional
    public void signup(User user){
        String rawpw=user.getUserpw();
        String hashpw=encoder.encode(rawpw);
        user.setUserpw(hashpw);
            userRepository.save(user);
    }

        @Transactional(readOnly = true)//정합성
    public User login(User user){
       return  userRepository.login(user.getUserid(),user.getUserpw());
    }
}
