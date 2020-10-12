package com.consorcio.pharmacy.config;

/**
 * Formato de respuesta ante cualquier excepcion
 */
public class ErrorResponse {
    /**
     * ejemplo 404 , no fue encontrado
     */
    private int code;
    /**
     * ejemplo : no se encontro el recurso
     */
    private String message;

    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
