package com.example.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAuthority('SCOPE_cep-api-server/hello')")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
