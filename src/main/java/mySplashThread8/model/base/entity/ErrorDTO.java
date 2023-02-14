package mySplashThread8.model.base.entity;


public class ErrorDTO {

   
    private int httpCode;

    private String message;

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorDTO(int httpCode, String message) {
        super();
        this.httpCode = httpCode;
        this.message = message;
    }

    public ErrorDTO() {
        super();
    }
}