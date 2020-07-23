package com.forezp.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MyController {

    @Value("${foo}")
    String foo;
    @RequestMapping(value = "/foo")
    public String hi(){
        return foo;
    }

}
