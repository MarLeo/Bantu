package com.tchokonthe.billboard.web;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tchokonthe.billboard.dto.TollRateDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
public class DashboardController {


    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;


    public static final Logger LOGGER = LoggerFactory.getLogger(DashboardController.class);


    @HystrixCommand(fallbackMethod = "getTollRateBackup")
    @RequestMapping(value = "/dashboard", produces = MediaType.APPLICATION_JSON_VALUE)
    public TollRateDTO getTollRate(@RequestParam int stationId, Model m) {
        TollRateDTO tr = restTemplate.getForObject("http://tollrate-service/tollrate/" + stationId, TollRateDTO.class);
        LOGGER.info("stationId : {}", stationId);
        m.addAttribute("rate", tr.getCurrentRate());
        return tr;
    }

    public TollRateDTO getTollRateBackup(@RequestParam int stationId, Model m) {
        LOGGER.info("fallback operation called !!!");
        m.addAttribute("rate", "1.00");
        return new TollRateDTO(stationId, new BigDecimal(1.00), "00:00:00");
    }


}
