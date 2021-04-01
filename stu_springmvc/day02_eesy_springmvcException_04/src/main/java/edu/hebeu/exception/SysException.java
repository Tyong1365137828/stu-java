package edu.hebeu.exception;

/**
 * 自定义异常类从
 */
public class SysException extends Exception{

    private String message;

    public SysException(String message) {
        System.out.println("SysException构造方法执行了...");
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
