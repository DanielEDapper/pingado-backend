package io.github.danieledapper.pingado.controller;

import io.github.danieledapper.pingado.dto.SubscriptionPlanRequest;
import io.github.danieledapper.pingado.dto.SubscriptionPlanResponse;
import io.github.danieledapper.pingado.entity.SubscriptionPlan;
import io.github.danieledapper.pingado.mapper.SubscriptionPlanMapper;
import io.github.danieledapper.pingado.service.SubscriptionPlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller REST responsável pelos endpoints de planos de assinatura.
 */
@RestController
@RequestMapping("/api/subscription-plans")
@Tag(name = "Planos de assinatura", description = "Gerencia os planos de assinatura.")
public class SubscriptionPlanController {

    private final SubscriptionPlanService service;

    /**
     * Cria o controller com seu service.
     *
     * @param service service responsável pelas regras de negócio
     */
    public SubscriptionPlanController(SubscriptionPlanService service) {
        this.service = service;
    }

    /**
     * Lista todos os registros.
     *
     * @return lista de respostas
     */
    @GetMapping
    @Operation(summary = "Listar todos", description = "Retorna todos os registros cadastrados.")
    @ApiResponse(responseCode = "200", description = "Registros retornados com sucesso.")
    public List<SubscriptionPlanResponse> findAll() {
        return service.findAll().stream().map(SubscriptionPlanMapper::toResponse).toList();
    }

    /**
     * Busca um registro pelo ID.
     *
     * @param id identificador do registro
     * @return registro encontrado
     */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar por ID", description = "Retorna um registro pelo seu identificador.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro encontrado."),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado.")
    })
    public SubscriptionPlanResponse findById(
            @Parameter(description = "ID do registro.", example = "1") @PathVariable Long id
    ) {
        return SubscriptionPlanMapper.toResponse(service.findById(id));
    }

    /**
     * Cria um novo registro.
     *
     * @param request dados recebidos no corpo da requisição
     * @return registro criado
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar", description = "Cria um novo registro.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Registro criado com sucesso."),
            @ApiResponse(responseCode = "409", description = "Conflito de regra de negócio.")
    })
    public SubscriptionPlanResponse create(@RequestBody SubscriptionPlanRequest request) {
        SubscriptionPlan saved = service.create(request);
        return SubscriptionPlanMapper.toResponse(saved);
    }

    /**
     * Atualiza um registro existente.
     *
     * @param id identificador do registro
     * @param request novos dados
     * @return registro atualizado
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar", description = "Atualiza um registro existente.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado."),
            @ApiResponse(responseCode = "409", description = "Conflito de regra de negócio.")
    })
    public SubscriptionPlanResponse update(
            @Parameter(description = "ID do registro.", example = "1") @PathVariable Long id,
            @RequestBody SubscriptionPlanRequest request
    ) {
        return SubscriptionPlanMapper.toResponse(service.update(id, request));
    }

    /**
     * Exclui um registro existente.
     *
     * @param id identificador do registro
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Excluir", description = "Exclui um registro existente.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Registro excluído com sucesso."),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado.")
    })
    public void delete(
            @Parameter(description = "ID do registro.", example = "1") @PathVariable Long id
    ) {
        service.delete(id);
    }
}
