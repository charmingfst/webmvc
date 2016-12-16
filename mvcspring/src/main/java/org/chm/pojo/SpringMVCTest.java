package org.chm.pojo;

import org.chm.pojo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Map;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

/**
 * Created by charming on 2016/12/14.
 */
@Controller
@RequestMapping("/springmvc")
public class SpringMVCTest {
    private static final String SUCCESS="success";
    @RequestMapping("/test")
    public String test()
    {
        System.out.println("hello world");
        return SUCCESS;
    }
    @RequestMapping("/testPojo")
    public String testPojo(@Valid User user, BindingResult result)
    {
        System.out.println("testPojo:"+user);
        if (result.getFieldErrorCount()>0)
        {
            for (FieldError error : result.getFieldErrors())
            {
                System.out.println(error.getField()+":"+error.getDefaultMessage());
            }
            return "forward:/index.jsp";
        }
        return SUCCESS;
    }

    /**
     * 了解
     * @param sessionId
     * @return
     */
    @RequestMapping("/testCookie")
    public String testCookie(@CookieValue("JSESSIONID") String sessionId)
    {
        System.out.println("sessionId:"+sessionId);
        return SUCCESS;
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map)
    {
        map.put("names", Arrays.asList("tom","james","marry"));
        return SUCCESS;
    }

    /**
     * 不自动绑定对象中的age属性，这时age为0
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.setDisallowedFields("age"); //
    }


}
