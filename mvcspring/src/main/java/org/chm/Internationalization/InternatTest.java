package org.chm.Internationalization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Map;

import static org.apache.taglibs.standard.resources.Resources.getMessage;

/**
 * Created by charming on 2016/12/15.
 */
@RequestMapping("internat")
@Controller
public class InternatTest {
    private static final String SUCCESS="success";

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @RequestMapping("/testLocal")
    public String testInternat(Locale locale, Map<String, String> map)
    {
        String msg = messageSource.getMessage("username", null, locale);
        map.put("username", msg);
        return "i18n";
    }
    @RequestMapping("/testFile")
    public String testFileUpload(@RequestParam("desc") String desc, @RequestParam("file")MultipartFile file)
    {
        System.out.println("desc:"+desc);
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());
        return SUCCESS;
    }

    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testFileDown(HttpSession session)
    {
        byte[] body = null;
        ServletContext servletContext = session.getServletContext();
        InputStream in = servletContext.getResourceAsStream("file/abc.txt");
        try {
            body = new byte[in.available()];
            in.read(body);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment;filename=abc.txt");
            HttpStatus status = HttpStatus.OK;
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(body, headers, status);
            return responseEntity;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


















}
