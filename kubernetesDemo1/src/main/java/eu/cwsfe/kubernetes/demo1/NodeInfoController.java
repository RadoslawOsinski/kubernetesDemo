package eu.cwsfe.kubernetes.demo1;

import org.json.JSONObject;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Radosław Osiński
 */
@Controller
public class NodeInfoController {

    private final Environment environment;

    public NodeInfoController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping(value = "/node")
    @ResponseBody
    public String getOK() throws UnknownHostException {
        JSONObject response = new JSONObject();
        response.put("appName", environment.getProperty("spring.application.name"));
        response.put("address", InetAddress.getLocalHost().getHostAddress());

        return response.toString();
    }

}
