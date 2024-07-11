package com.Agenda_back.Agendamentos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // Set response status to 404 (Not Found)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Recurso não encontrado"); // Default message
    }

    public ResourceNotFoundException(String message) {
        super(message); // Customized message
    }
}