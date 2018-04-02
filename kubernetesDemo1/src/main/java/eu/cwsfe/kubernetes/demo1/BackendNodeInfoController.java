package eu.cwsfe.kubernetes.demo1;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;

/**
 * Created by Radosław Osiński
 */
@Controller
public class BackendNodeInfoController {

    private static final Logger LOG = LoggerFactory.getLogger(BackendNodeInfoController.class);

    private final Environment environment;

    public BackendNodeInfoController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping(value = "/backendNode")
    @ResponseBody
    public String getAddresses() throws UnknownHostException {
        String demo2Url = environment.getProperty("eu.cwsfe.kubernetes.demo2.url");
        LOG.info("Request to url: {}", demo2Url);
        String nodeResponse = new RestTemplate().getForObject(demo2Url + "/node", String.class);

        JSONObject response = new JSONObject();
        response.put("appName", environment.getProperty("spring.application.name"));
        response.put("address", InetAddress.getLocalHost().getHostAddress());
        response.put("backendAddress", new JSONObject(nodeResponse).get("address"));

        return response.toString();
    }

}
