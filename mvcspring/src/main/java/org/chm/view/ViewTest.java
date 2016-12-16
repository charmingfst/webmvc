package org.chm.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by charming on 2016/12/14.
 */
@RequestMapping("/view")
@Controller
public class ViewTest {
    private static final String SUCCESS="success";
    @RequestMapping("/testView")
    public String testView()
    {
        return "myView";
    }
    @RequestMapping("testRedirect")
    public String testRedirect()
    {
        System.out.println("redirect");
        return "redirect:/view/testView";
    }


}
