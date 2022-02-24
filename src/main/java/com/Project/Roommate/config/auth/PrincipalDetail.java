package com.Project.Roommate.config.auth;

import com.Project.Roommate.Entity.User;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Getter
public class PrincipalDetail implements UserDetails {
    private User user;
    public PrincipalDetail(User user) {
        this.user = user;
    }




    @Override
    public String toString() {
        return user.getUserid();
    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> collectior=new ArrayList<>();
//        collectior.add(new GrantedAuthority() {
//            @Override
//            public String getAuthority() {
//                return null;
//            }
//        });
//        return null;
////        Collection<GrantedAuthority> collectior=new ArrayList<>();
////        collectior.add(()->{return "ROLE_"+user.getRole();});
////        return  collectior;
        return null;
    }

    @Override
    public String getPassword() {
        return user.getUserpw();
    }

    @Override
    public String getUsername() {
        return user.getUserid();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
