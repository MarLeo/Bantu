package com.tchokonthe.fastpass.web;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tchokonthe.fastpass.dto.FastPassCustomer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
public class FastPassController {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;

    public static final Logger LOGGER = LoggerFactory.getLogger(FastPassController.class);

    @HystrixCommand(fallbackMethod = "getFastPassCustomerDetailsBackup")
    @RequestMapping(path="/customerdetails", params={"fastpassid"})
    public FastPassCustomer getFastPassCustomerDetails(@RequestParam String fastpassid, Model m) {

        FastPassCustomer c = restTemplate.getForObject("http://fastpass-service/fastpass?fastpassid=" + fastpassid, FastPassCustomer.class);
        LOGGER.info("retrieved customer details");
        m.addAttribute("customer", c);
        return c;
    }


    public FastPassCustomer getFastPassCustomerDetailsBackup(@RequestParam String fastpassid, Model m) {
        LOGGER.info("fallback method call !!!!");
        return new FastPassCustomer(fastpassid, "Richard Seroter", "555-123-4567", new BigDecimal("19.50"));
    }

    }
