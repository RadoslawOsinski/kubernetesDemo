package eu.cwsfe.kubernetes.demo;

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

    @GetMapping(value = "/node")
    @ResponseBody
    public String getOK() throws UnknownHostException {
        return "{\"address\": \"" + InetAddress.getLocalHost().getHostAddress() + "\"}";
    }

}
