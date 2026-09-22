package io.github.danieledapper.pingado.service;

import io.github.danieledapper.pingado.dto.UserRequest;
import io.github.danieledapper.pingado.entity.User;
import io.github.danieledapper.pingado.exception.EmailAlreadyExistsException;
import io.github.danieledapper.pingado.exception.UserNotFoundException;
import io.github.danieledapper.pingado.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Regras de negócio e operações de persistência dos usuários.
 */
@Service
public class UserService {

    private final UserRepository repository;

    /**
     * Cria o service com seu repository.
     *
     * @param repository repository de usuários
     */
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    /** @return todos os usuários cadastrados */
    public List<User> findAll() { return repository.findAll(); }

    /**
     * Busca um usuário pelo ID.
     *
     * @param id identificador do usuário
     * @return usuário encontrado
     * @throws UserNotFoundException quando o ID não existir
     */
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * Cria um usuário validando a unicidade do e-mail.
     *
     * @param request dados do usuário
     * @return usuário persistido
     * @throws EmailAlreadyExistsException quando o e-mail já estiver cadastrado
     */
    public User create(UserRequest request) {
        repository.findByEmail(request.email()).ifPresent(user -> {
            throw new EmailAlreadyExistsException(request.email());
        });
        return repository.save(new User(null, request.name(), request.email(), request.password(), request.role()));
    }

    /**
     * Atualiza um usuário e permite que ele mantenha seu próprio e-mail.
     *
     * @param id identificador do usuário
     * @param request novos dados
     * @return usuário atualizado
     * @throws UserNotFoundException quando o ID não existir
     * @throws EmailAlreadyExistsException quando o e-mail pertencer a outro usuário
     */
    public User update(Long id, UserRequest request) {
        User user = findById(id);
        repository.findByEmail(request.email())
                .filter(existing -> !existing.getId().equals(id))
                .ifPresent(existing -> { throw new EmailAlreadyExistsException(request.email()); });
        user.setName(request.name());
        user.setEmail(request.email());
        user.setPassword(request.password());
        user.setRole(request.role());
        return repository.save(user);
    }

    /**
     * Exclui um usuário existente.
     *
     * @param id identificador do usuário
     * @throws UserNotFoundException quando o ID não existir
     */
    public void delete(Long id) {
        User user = findById(id);
        repository.delete(user);
    }
}
