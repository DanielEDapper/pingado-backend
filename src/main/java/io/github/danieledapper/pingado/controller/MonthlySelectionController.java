package io.github.danieledapper.pingado.controller;

import io.github.danieledapper.pingado.dto.MonthSelectionRequest;
import io.github.danieledapper.pingado.dto.MonthSelectionResponse;
import io.github.danieledapper.pingado.entity.MonthlySelection;
import io.github.danieledapper.pingado.mapper.MonthSelectionMapper;
import io.github.danieledapper.pingado.service.MonthlySelectionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller REST responsável pelos endpoints de seleções mensais.
 */
@RestController
@RequestMapping("/api/monthly-selections")
@Tag(name = "Seleções mensais", description = "Gerencia as seleções mensais de cafés.")
public class MonthlySelectionController {

    private final MonthlySelectionService service;

    /**
     * Cria o controller com seu service.
     *
     * @param service service responsável pelas regras de negócio
     */
    public MonthlySelectionController(MonthlySelectionService service) {
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
    public List<MonthSelectionResponse> findAll() {
        return service.findAll().stream().map(MonthSelectionMapper::toResponse).toList();
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
    public MonthSelectionResponse findById(
            @Parameter(description = "ID do registro.", example = "1") @PathVariable Long id
    ) {
        return MonthSelectionMapper.toResponse(service.findById(id));
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
    public MonthSelectionResponse create(@RequestBody MonthSelectionRequest request) {
        MonthlySelection selection = MonthSelectionMapper.toEntity(request);
        MonthlySelection saved = service.create(selection);
        return MonthSelectionMapper.toResponse(saved);
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
    public MonthSelectionResponse update(
            @Parameter(description = "ID do registro.", example = "1") @PathVariable Long id,
            @RequestBody MonthSelectionRequest request
    ) {
        return MonthSelectionMapper.toResponse(service.update(id, request));
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
