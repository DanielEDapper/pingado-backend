package io.github.danieledapper.pingado.service;

import io.github.danieledapper.pingado.entity.User;
import io.github.danieledapper.pingado.exception.UserInformationsIncorrectException;
import io.github.danieledapper.pingado.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService
{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id)
    {
        return userRepository.findById(id);
    }

    public User save(User user)
    {
        String nome = user.getName();
        String email = user.getEmail();
        String senha = user.getPassword();

        if(nome.isBlank() || nome.length() < 2 || email.isBlank() || senha.isBlank())
        {
            throw new UserInformationsIncorrectException("INFORMAÇÕES INCORRETAS NO CADASTRO DO USUÁRIO");
        }

        return userRepository.save(user);
    }

    public void update(Long id, User user)
    {
        findById(id);
        userRepository.update(id, user);
        user.setId(id);
    }

    public void delete(Long id)
    {
        findById(id);
        userRepository.deleteById(id);
    }
}