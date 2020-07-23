package com.forezp.servicemiya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
public class TestController {

    private static final Logger log= Logger.getLogger(TestController.class.getName());

    @Value("${server.port}")
    String port;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    @GetMapping("/hello")
    public String sayhello(){
        return "hello world!";
    }

    @GetMapping("/info")
    public String info(){
        log.log(Level.INFO, "hi is being called");
        return restTemplate.getForObject("http://localhost:8762/hi?name=miya",String.class);
    }

}

