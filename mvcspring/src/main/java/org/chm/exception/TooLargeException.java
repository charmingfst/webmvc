package org.chm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

/**
 * Created by charming on 2016/12/16.
 */
@ResponseStatus(value = HttpStatus.PAYLOAD_TOO_LARGE, reason = "太大了")
public class TooLargeException extends RuntimeException {

}
