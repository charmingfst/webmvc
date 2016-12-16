package org.chm.attribute;

import org.chm.pojo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

/**
 * Created by charming on 2016/12/14.
 */
@Controller
@RequestMapping("/attribute")
//@SessionAttributes(types = User.class)
@SessionAttributes(value = {"user"})
public class AttributeTest {

    private static final String SUCCESS="success";

    @RequestMapping("/testSessionAttribute")
    public String testSessionAttribute(Map<String, Object> map)
    {
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123");
        user.setAge(22);
        map.put("user", user);
        return SUCCESS;
    }
//    @ModelAttribute
//    private void getUser(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map)
//    {
//        System.out.println("modelattribute");
//        if (id != null) {
//            User user = new User();
//            user.setId(1);
//            user.setUsername("zhangsan");
//            user.setPassword("112233");
//            user.setAge(22);
//            //注意键值
//            map.put("user", user);
//            System.out.println("模型从数据获取的user对象："+user);
//        }
//    }

    /**
     * 运行流程：
     * 1.执行@ModelAttribute注解修饰的方法：从数据库中取出对象，把对象放入到Map中。键为：user
     * 2.SpringMVC 从Map中取出Userd对象，并把表单的请求参数赋给该User对象的对应属性。
     * 3.SpringMvc 把上述对象传给目标方法的参数
     * 注意：在@ModelAttribute修饰的方法中，放入到Map时的键需要和目标方法参数类型的第一个字母小写的字符串一致！
     * @param user
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user)
    {
        System.out.println("修改后的user:"+user);
        return SUCCESS;
    }

}
