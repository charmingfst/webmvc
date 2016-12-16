package org.chm.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import static com.sun.xml.internal.ws.api.message.Packet.Status.Request;

/**
 * Created by charming on 2016/12/16.
 */
@RequestMapping("/exception")
@Controller
public class HanldeExceptionTest {

    /**
     *  1. 在@ExceptionHandler方法的入参中可以加入Exception类型的参数，改参数即对应发生的异常对象
     *  2. @ExceptionHandler方法的入参中不能传入Map.若希望把异常信息传到页面也，需要使用ModelAndView作为返回值
     *  3. @ExceptionHandler方法标记的异常有优先级的问题，类似try-catch捕捉异常的先后顺序
     *  4. @ControllerAdvice:如果在当前Handler中找不到@ExceptionHandler方法来处理当前发生的异常，则去@ControllerAdvice标记的类中查询@ExceptionHandler标记的方法来处理异常
     * @param ex
     * @return
     */

    @ExceptionHandler
    public ModelAndView handleException(ArithmeticException ex)
    {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", ex);
        return mv;
    }

    @RequestMapping("/testException")
    public String testExceptionHandler(@RequestParam("num") int num)
    {
        int res = 10/num;
        return "success";
    }

    @RequestMapping("/testResponse")
    public String testResponseException(@RequestParam("num") int num)
    {
        if (num>100)
        {
            throw new TooLargeException();
        }
        return "success";
    }
}
