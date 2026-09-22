package io.github.danieledapper.pingado.controller;

import io.github.danieledapper.pingado.dto.PaymentRequest;
import io.github.danieledapper.pingado.dto.PaymentResponse;
import io.github.danieledapper.pingado.entity.Payment;
import io.github.danieledapper.pingado.mapper.PaymentMapper;
import io.github.danieledapper.pingado.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping
    public List<PaymentResponse> findAll() {
        return service.findAll()
                .stream()
                .map(PaymentMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public PaymentResponse findById(@PathVariable Long id) {
        return PaymentMapper.toResponse(service.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponse create(
            @RequestBody PaymentRequest request
    ) {
        Payment payment = service.create(request);
        return PaymentMapper.toResponse(payment);
    }

    @PutMapping("/{id}")
    public PaymentResponse update(
            @PathVariable Long id,
            @RequestBody PaymentRequest request
    ) {
        return PaymentMapper.toResponse(
                service.update(id, request)
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}