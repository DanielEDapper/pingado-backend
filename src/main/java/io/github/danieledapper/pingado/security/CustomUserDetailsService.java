package io.github.danieledapper.pingado.security;

import io.github.danieledapper.pingado.entity.User;
import io.github.danieledapper.pingado.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        System.out.println(">>> PROCURANDO USUÁRIO: " + email);

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    System.out.println(">>> USUÁRIO NÃO ENCONTRADO");
                    return new UsernameNotFoundException(
                            "Usuário não encontrado"
                    );
                });

        System.out.println(">>> USUÁRIO ENCONTRADO: " + user.getEmail());
        System.out.println(">>> ROLE: " + user.getRole());

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }
}