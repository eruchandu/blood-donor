package com.example.blooddonor.exception;

public class DonorNotFoundException extends RuntimeException {

    public DonorNotFoundException(Long id) {
        super("Donor not found with id: " + id);
    }

    public static class GlobalExceptionHandler extends RuntimeException {
        public GlobalExceptionHandler(String message) {
            super(message);
        }
    }
}