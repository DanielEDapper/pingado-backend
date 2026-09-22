package io.github.danieledapper.pingado.service;

import io.github.danieledapper.pingado.dto.MonthlySelectionRequest;
import io.github.danieledapper.pingado.entity.MonthlySelection;
import io.github.danieledapper.pingado.exception.MonthlySelectionNotFoundException;
import io.github.danieledapper.pingado.repository.MonthlySelectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Regras de negócio e operações de persistência das seleções mensais.
 */
@Service
public class MonthlySelectionService {

    private final MonthlySelectionRepository monthlySelectionRepository;

    /**
     * Cria o service com seu repository.
     *
     * @param monthlySelectionRepository repository de seleções mensais
     */
    public MonthlySelectionService(MonthlySelectionRepository monthlySelectionRepository) {
        this.monthlySelectionRepository = monthlySelectionRepository;
    }

    /**
     * Persiste uma seleção mensal.
     *
     * @param monthlySelection entidade a ser salva
     * @return entidade persistida
     */
    public MonthlySelection create(MonthlySelection monthlySelection) {
        return monthlySelectionRepository.save(monthlySelection);
    }

    /** @return todas as seleções mensais */
    public List<MonthlySelection> findAll() { return monthlySelectionRepository.findAll(); }

    /**
     * Busca uma seleção mensal pelo ID.
     *
     * @param id identificador da seleção
     * @return seleção encontrada
     * @throws MonthlySelectionNotFoundException quando o ID não existir
     */
    public MonthlySelection findById(Long id) {
        return monthlySelectionRepository.findById(id)
                .orElseThrow(() -> new MonthlySelectionNotFoundException(id));
    }

    /**
     * Atualiza os campos de uma seleção existente usando o padrão JPA.
     *
     * @param id identificador da seleção
     * @param request novos dados
     * @return seleção atualizada
     * @throws MonthlySelectionNotFoundException quando o ID não existir
     */
    public MonthlySelection update(Long id, MonthlySelectionRequest request) {
        MonthlySelection selection = findById(id);
        selection.setMonth(request.month());
        selection.setYear(request.year());
        selection.setTitle(request.title());
        selection.setDescription(request.description());
        return monthlySelectionRepository.save(selection);
    }

    /**
     * Exclui uma seleção mensal existente.
     *
     * @param id identificador da seleção
     * @throws MonthlySelectionNotFoundException quando o ID não existir
     */
    public void delete(Long id) {
        findById(id);
        monthlySelectionRepository.deleteById(id);
    }
}
