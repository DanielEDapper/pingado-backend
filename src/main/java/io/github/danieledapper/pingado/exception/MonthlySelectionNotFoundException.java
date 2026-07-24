package io.github.danieledapper.pingado.exception;

public class MonthlySelectionNotFoundException extends RuntimeException {
    public MonthlySelectionNotFoundException(Long id) {
        super("MonthlySelection not found with id: "+id);
    }
}
