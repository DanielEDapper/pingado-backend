package io.github.danieledapper.pingado.service;

import io.github.danieledapper.pingado.dto.UserRequest;
import io.github.danieledapper.pingado.entity.User;
import io.github.danieledapper.pingado.exception.EmailAlreadyExistsException;
import io.github.danieledapper.pingado.exception.UserNotFoundException;
import io.github.danieledapper.pingado.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public User create(UserRequest request) {
        repository.findByEmail(request.email())
                .ifPresent(user -> {
                    throw new EmailAlreadyExistsException(
                            request.email()
                    );
                });

        User user = new User(
                null,
                request.name(),
                request.email(),
                request.password(),
                request.role()
        );

        return repository.save(user);
    }

    public User update(Long id, UserRequest request) {
        User user = findById(id);

        repository.findByEmail(request.email())
                .filter(existing -> !existing.getId().equals(id))
                .ifPresent(existing -> {
                    throw new EmailAlreadyExistsException(
                            request.email()
                    );
                });

        user.setName(request.name());
        user.setEmail(request.email());
        user.setPassword(request.password());
        user.setRole(request.role());

        return repository.save(user);
    }

    public void delete(Long id) {
        User user = findById(id);
        repository.delete(user);
    }
}