package br.com.alura.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class helloController {

    @Controller
    public static class HelloController {

        @RequestMapping("/")
        @ResponseBody
        public String hello(){
            return "hello world aula 1!";
        }
    }
}
