package io.github.danieledapper.pingado.controller;

import io.github.danieledapper.pingado.dto.UserSubscriptionRequest;
import io.github.danieledapper.pingado.dto.UserSubscriptionResponse;
import io.github.danieledapper.pingado.entity.UserSubscription;
import io.github.danieledapper.pingado.mapper.UserSubscriptionMapper;
import io.github.danieledapper.pingado.service.UserSubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class UserSubscriptionController {

    private final UserSubscriptionService service;

    public UserSubscriptionController(
            UserSubscriptionService service
    ) {
        this.service = service;
    }

    @GetMapping
    public List<UserSubscriptionResponse> findAll() {
        return service.findAll()
                .stream()
                .map(UserSubscriptionMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public UserSubscriptionResponse findById(
            @PathVariable Long id
    ) {
        return UserSubscriptionMapper.toResponse(
                service.findById(id)
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserSubscriptionResponse create(
            @RequestBody UserSubscriptionRequest request
    ) {
        UserSubscription subscription = service.create(request);
        return UserSubscriptionMapper.toResponse(subscription);
    }

    @PutMapping("/{id}")
    public UserSubscriptionResponse update(
            @PathVariable Long id,
            @RequestBody UserSubscriptionRequest request
    ) {
        return UserSubscriptionMapper.toResponse(
                service.update(id, request)
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}