package io.github.danieledapper.pingado.mapper;

import io.github.danieledapper.pingado.dto.UserRequest;
import io.github.danieledapper.pingado.dto.UserResponse;
import io.github.danieledapper.pingado.entity.User;

public class UserMapper {

    private UserMapper() {
    }

    public static User toEntity(UserRequest request) {
        return new User(
                null,
                request.name(),
                request.email(),
                request.password(),
                request.role()
        );
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }
}