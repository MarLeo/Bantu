package com.tchokonthe.tollrate.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TollRateDTO {

    private int stationId;
    private BigDecimal currentRate;
    private String timestamp;

    public TollRateDTO() {}

    public TollRateDTO(int stationId, BigDecimal currentRate, String timestamp) {
        this.stationId = stationId;
        this.currentRate = currentRate;
        this.timestamp = timestamp;
    }



}
