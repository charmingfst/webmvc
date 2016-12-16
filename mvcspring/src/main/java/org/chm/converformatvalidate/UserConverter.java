package org.chm.converformatvalidate;

import org.chm.pojo.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by charming on 2016/12/15.
 */
@Component
public class UserConverter implements Converter<String, User> {
    public User convert(String s) {

        if (s != null)
        {
            String[] args = s.split("-");
            if (args.length > 0)
            {
                User user = new User();
                user.setUsername(args[0]);
                user.setPassword(args[1]);
                user.setAge(Integer.parseInt(args[2]));
                return user;
            }

        }

        return null;
    }
}
