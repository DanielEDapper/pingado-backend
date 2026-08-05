package io.github.danieledapper.pingado.exception;

public class MonthlySelectionNotFoundException extends ResourceNotFoundException {
    public MonthlySelectionNotFoundException(Long id) {
        super("MonthlySelection not found with id: "+id);
    }
}
