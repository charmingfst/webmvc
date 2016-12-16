package org.chm.converformatvalidate;

import org.chm.pojo.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by charming on 2016/12/15.
 */
@RequestMapping("/data")
@Controller
public class DataTest {
    public static final String SUCCESS="success";

    @RequestMapping("/testConverter")
    public String testConverter(@Valid User user, BindingResult result)
    {
        System.out.println(user);
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
    @RequestMapping("/testValidate")
    public String testValidate(@Valid User user, BindingResult result)
    {
        if (result.getFieldErrorCount()>0)
        {
            for (FieldError error : result.getFieldErrors())
            {
                System.out.println(error.getField()+":"+error.getDefaultMessage());
            }
            return "forward:/input.jsp";
        }
        return SUCCESS;
    }
}
