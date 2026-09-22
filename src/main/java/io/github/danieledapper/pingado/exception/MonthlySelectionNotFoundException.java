package io.github.danieledapper.pingado.exception;

public class MonthlySelectionNotFoundException extends RecourceNotFoundException {
    public MonthlySelectionNotFoundException(Long id) {
        super("MonthlySelection not found with id: "+id);
    }
}
