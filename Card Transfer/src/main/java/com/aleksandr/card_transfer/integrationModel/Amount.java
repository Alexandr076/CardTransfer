package com.aleksandr.card_transfer.integrationModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Amount {

    @NotNull(message = "The value is required")
    private Integer value;

    @NotNull(message = "The currency is required")
    @NotBlank(message = "The currency won`t blank")
    private String currency;

    public Integer getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }
}
