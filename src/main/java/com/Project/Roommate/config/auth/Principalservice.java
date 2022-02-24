package com.Project.Roommate.config.auth;

import com.Project.Roommate.Entity.User;
import com.Project.Roommate.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Principalservice implements UserDetailsService {



    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          User principal=userRepository.findByUserid(username)
                .orElseThrow(()->{
                    return new UsernameNotFoundException("해당 사용자가 없습니다"+username);
                });
        return new PrincipalDetail(principal);
    }
}
