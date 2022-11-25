package org.soulcodeacademy.helpr.controllers.errors;

import java.time.LocalDateTime;

//Esta classe customiza a resposta de erro original do Spring
public class CustomErrorResponse {
    private String message;           //msg explicando o erro
    private Integer status;           // código de status HTTP
    private LocalDateTime timestamp;  // registro da data e hora do erro
    private String path;              // endpoint em que ocorreu o erro


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
