package com.dickanirwansyah.jwt.springbootjwtauthentication.service;

import com.dickanirwansyah.jwt.springbootjwtauthentication.dao.UserDAO;
import com.dickanirwansyah.jwt.springbootjwtauthentication.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = userDAO.findOneCredentialsByusername(username);
        if(users == null){
            throw new UsernameNotFoundException("User '"+ username + "'Not Found !");
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(users.getPassword())
                .authorities(Collections.emptyList())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
