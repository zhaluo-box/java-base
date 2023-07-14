package org.example.open.lib.learn.exception;

/**
 * Created  on 2022/3/10 10:10:27
 *
 * @author wmz
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable t) {
        super(message, t);
    }

    public BusinessException(Throwable t) {
        super(t);
    }

}
