package io.github.danieledapper.pingado.mapper;

import io.github.danieledapper.pingado.dto.UserRequest;
import io.github.danieledapper.pingado.dto.UserResponse;
import io.github.danieledapper.pingado.entity.User;

/**
 * Conversor entre a entidade User e seus DTOs.
 */
public final class UserMapper {

    private UserMapper() {
    }

    /**
     * Converte um request em entidade.
     *
     * @param request dados recebidos pela API
     * @return entidade User
     */
    public static User toEntity(UserRequest request) {
        return new User(null, request.name(), request.email(), request.password(), request.role());
    }

    /**
     * Converte uma entidade em resposta sem expor a senha.
     *
     * @param user entidade de usuário
     * @return DTO público do usuário
     */
    public static UserResponse toResponse(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getRole());
    }
}
