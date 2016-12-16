package org.chm.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by charming on 2016/12/16.
 */
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler
    public ModelAndView handleException(ArithmeticException ex)
    {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", ex);
        System.out.println("出错了："+ex);
        return mv;
    }
}
