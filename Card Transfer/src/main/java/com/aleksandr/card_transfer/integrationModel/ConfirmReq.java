package com.aleksandr.card_transfer.integrationModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ConfirmReq implements Request{

    @NotNull(message = "The operationId is required")
    @NotBlank(message = "The operationId won`t blank")
    private String operationId;

    @NotNull(message = "The code is required")
    @NotBlank(message = "The code won`t blank")
    private String code;

}
