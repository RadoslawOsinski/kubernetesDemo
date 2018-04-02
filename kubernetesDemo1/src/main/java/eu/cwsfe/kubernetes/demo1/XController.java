package eu.cwsfe.kubernetes.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Radosław Osiński
 */
@Controller
public class XController {

    @GetMapping(value = "/", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String getX() {
        return "{\"hello\": \"world\"}";
    }
}
