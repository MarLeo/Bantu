package com.tchokonthe.tollrate.web;


import com.tchokonthe.tollrate.dto.TollRateDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Instant;

@RestController
public class TollRateController {

    @RequestMapping(value = "/tollrate/{stationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TollRateDTO getTollRate(@PathVariable int stationId) {

        TollRateDTO tr;

        switch(stationId) {
            case 1:
                tr = new TollRateDTO(stationId, new BigDecimal("0.55"), Instant.now().toString());
                break;
            case 2:
                tr = new TollRateDTO(stationId, new BigDecimal("1.05"), Instant.now().toString());
                break;
            case 3:
                tr = new TollRateDTO(stationId, new BigDecimal("0.60"), Instant.now().toString());
                break;
            default:
                tr = new TollRateDTO(stationId, new BigDecimal("1.00"), Instant.now().toString());
                break;
        }

        return tr;
    }



}
