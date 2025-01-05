package com.example.demo.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id) {
        super("Item not found with id: " + id);
    }
}

