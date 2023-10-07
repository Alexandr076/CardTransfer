package com.aleksandr.card_transfer.model;

import com.aleksandr.card_transfer.integrationModel.Amount;

public class AmountInfo {

    private Integer value;
    private String currency;

    public AmountInfo(Amount amount) {
        this.value = amount.getValue();
        this.currency = amount.getCurrency();
    }

    public Integer getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }
}
