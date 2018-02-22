package com.tchokonthe.fastpass.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FastPassCustomer {

    private String fastPassId;
    private String customerFullName;
    private String fastPassPhone;
    private BigDecimal currentBalance;

    public FastPassCustomer() {}

    public FastPassCustomer (String fastPassId, String customerFullName, String fastPassPhone, BigDecimal currentBalance) {
        this.fastPassId = fastPassId;
        this.customerFullName = customerFullName;
        this.fastPassPhone = fastPassPhone;
        this.currentBalance = currentBalance;
    }
}
