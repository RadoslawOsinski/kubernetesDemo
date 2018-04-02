package eu.cwsfe.kubernetes.demo2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Radosław Osiński
 */
@Controller
public class LivenessHealthController {

    @GetMapping(value = "/liveness/health")
    @ResponseBody
    public String getOK() {
        return "{\"status\": \"OK\"}";
    }
}
