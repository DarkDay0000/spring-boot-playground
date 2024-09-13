package com.gmail.dev.surovtsev.yaroslav.springbootplayground.services;

import com.gmail.dev.surovtsev.yaroslav.springbootplayground.models.CustomUser;
import com.gmail.dev.surovtsev.yaroslav.springbootplayground.repositories.CustomUsersRepository;
import com.gmail.dev.surovtsev.yaroslav.springbootplayground.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final CustomUsersRepository customUsersRepository;

    @Autowired
    public CustomUserDetailsService(CustomUsersRepository customUsersRepository) {
        this.customUsersRepository = customUsersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<CustomUser> customUser = customUsersRepository.findByUsername(s);

        if (customUser.isEmpty()) {
            throw new UsernameNotFoundException("User \"" + s + "\" not found");
        }

        return new CustomUserDetails(customUser.get());
    }
}
