package org.example.open.lib.learn.exception;

/**
 * Created  on 2022/3/10 10:10:27
 *
 * @author wmz
 */
public class BadRequestException extends BusinessException {
    public BadRequestException(String message) {
        super(message);
    }
}
