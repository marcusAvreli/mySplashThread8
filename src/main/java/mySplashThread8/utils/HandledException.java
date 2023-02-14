package mySplashThread8.utils;

public class HandledException extends Exception {
    private String code;
    private String headerName;

    public HandledException(String code, String message) {
        super(message);
        this.setCode(code);
    }
    public HandledException(String code,String headerName, String message) {
        super(message);
        this.setCode(code);
        this.setHeaderName(headerName);
    }
    public String getHeaderName() {
		return headerName;
	}
	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}
	public HandledException(String code, String message, Throwable cause) {
        super(message, cause);
        this.setCode(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}