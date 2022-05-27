package com.example.provider;

import com.example.dto.CustomGrantedAuthorityDto;
import com.example.dto.CustomUserDetailsDto;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.enums.RoleType;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        final User user = userRepository.findByUsernameIgnoreCaseAndDeletedFalse(username)
              .orElseThrow(() -> new UsernameNotFoundException(username));

        Set<CustomGrantedAuthorityDto> authorities = user.getRoles()
              .stream()
              .map(Role::getName)
              .map(RoleType::name)
              .map(CustomGrantedAuthorityDto::new)
              .collect(Collectors.toSet());

        return new CustomUserDetailsDto()
              .setUsername(user.getUsername())
              .setPassword(user.getPassword())
              .setGrantedAuthorities(authorities);
    }
}
