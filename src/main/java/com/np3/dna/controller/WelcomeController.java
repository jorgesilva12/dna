package com.np3.dna.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class WelcomeController {
    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String welcome(){return "<html>\n" + "<header><title>Chruch System</title></header>\n" +
            "<body>\n"+ "<h3>Welcome to the DNA - projects management.</h3>\n\n" + "We are this moment in build\n" + "</body>\n" + "</html>";}
}