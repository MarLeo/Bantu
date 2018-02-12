package com.tchokonthe.details.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DetailsController {

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "hello world";
    }

}
