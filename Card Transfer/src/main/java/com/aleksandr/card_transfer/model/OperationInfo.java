package com.aleksandr.card_transfer.model;

import com.aleksandr.card_transfer.integrationModel.Amount;
import com.aleksandr.card_transfer.integrationModel.TransferReq;

public class OperationInfo {
    private String cardFromNumber;
    private String cardFromValidTill;
    private String cardFromCVV;
    private String cardToNumber;
    private AmountInfo amountInfo;
    private String code;

    public OperationInfo(TransferReq transferReq) {
        this.cardFromNumber = transferReq.getCardFromNumber();
        this.cardFromValidTill = transferReq.getCardFromValidTill();
        this.cardFromCVV = transferReq.getCardFromCVV();
        this.cardToNumber = transferReq.getCardToNumber();
        this.amountInfo = new AmountInfo(transferReq.getAmount());
    }

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

    public AmountInfo getAmountInfo() {
        return amountInfo;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

