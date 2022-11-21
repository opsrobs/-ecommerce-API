package com.ecommerce.api.apiecommerce.configs.security;
import com.ecommerce.api.apiecommerce.Models.PessoaModels;
import com.ecommerce.api.apiecommerce.Repositories.UserRepositories;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    final UserRepositories userRepository;

    public UserDetailsServiceImpl(UserRepositories userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PessoaModels userModel = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return new User(userModel.getUsername(),
                userModel.getPassword(),
                true,
                true,
                true,
                true,
                userModel.getAuthorities());
    }
}