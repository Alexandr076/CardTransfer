package com.aleksandr.card_transfer.integrationModel;

import com.aleksandr.card_transfer.integrationModel.Amount;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransferReq implements Request{

    @NotNull(message = "The cardFromNumber is required")
    @NotBlank(message = "The cardFromNumber won`t blank")
    private String cardFromNumber;

    @NotNull(message = "The cardFromValidTill is required")
    @NotBlank(message = "The cardFromValidTill won`t blank")
    private String cardFromValidTill;

    @NotNull(message = "The cardFromCVV is required")
    @NotBlank(message = "The cardFromCVV won`t blank")
    private String cardFromCVV;

    @NotNull(message = "The cardToNumber is required")
    @NotBlank(message = "The cardToNumber won`t blank")
    private String cardToNumber;

    public String getCardFromNumber() {
        return cardFromNumber;
    }

    public String getCardFromValidTill() {
        return cardFromValidTill;
    }

    public String getCardFromCVV() {
        return cardFromCVV;
    }

    public String getCardToNumber() {
        return cardToNumber;
    }

    public Amount getAmount() {
        return amount;
    }

    @Valid
    @NotNull(message = "The amount is required")
    private Amount amount;

}
