package io.github.danieledapper.pingado.error;

import io.github.danieledapper.pingado.exception.EmailAlreadyExistsException;
import io.github.danieledapper.pingado.exception.RecourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * Tratamento centralizado das exceções lançadas pelos endpoints REST.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Trata recursos não encontrados.
     *
     * @param ex exceção de recurso não encontrado
     * @return resposta HTTP 404 padronizada
     */
    @ExceptionHandler(RecourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(RecourceNotFoundException ex) {
        ErrorResponse response = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    /**
     * Trata tentativas de cadastro com e-mail já utilizado.
     *
     * @param ex exceção de conflito de e-mail
     * @return resposta HTTP 409 padronizada
     */
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleEmailAlreadyExists(EmailAlreadyExistsException ex) {
        ErrorResponse response = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    /**
     * Trata erros não previstos sem expor detalhes internos da aplicação.
     *
     * @param ex exceção inesperada
     * @return resposta HTTP 500 com mensagem genérica
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse response = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An unexpected internal error occurred.",
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
