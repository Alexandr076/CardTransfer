package com.aleksandr.card_transfer.log;

import com.aleksandr.card_transfer.OperationNames;
import com.aleksandr.card_transfer.integrationModel.ConfirmReq;
import com.aleksandr.card_transfer.integrationModel.Request;
import com.aleksandr.card_transfer.integrationModel.TransferReq;
import com.aleksandr.card_transfer.model.OperationInfo;
import jdk.jfr.Timestamp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

@Component
public class Log {

    @Value("${cardTransferApp.fileToLogName}")
    private String fileToLogName;

    private String getTransferLog(Request request) {
        TransferReq transferReq = (TransferReq) request;
        StringBuilder simpleLog = new StringBuilder();
        simpleLog
                .append(java.time.LocalDateTime.now().toString())
                .append(" INFO ")
                .append("[")
                .append("Transfer")
                .append("]: ")
                .append("CardFromNumber: ")
                .append(transferReq.getCardFromNumber() + "; ")
                .append("CardToNumber: ")
                .append(transferReq.getCardToNumber() + "; ")
                .append("Amount: ")
                .append(transferReq.getAmount().getValue() + " ")
                .append(transferReq.getAmount().getCurrency() + "; ")
                .append("\n");
        return simpleLog.toString();
    }

    private String getConfirmLog(Request request) {
        ConfirmReq confirmReq = (ConfirmReq) request;
        StringBuilder simpleLog = new StringBuilder();
        simpleLog
                .append(java.time.LocalDateTime.now().toString())
                .append(" INFO ")
                .append("[")
                .append("Confirm")
                .append("]: ")
                .append("operationID: ")
                .append(confirmReq.getOperationId() + " ")
                .append("success")
                .append("\n");
        return simpleLog.toString();
    }

    public void toLogFile(Request request, String operationName) throws Exception{
        String simpleLog = "";
        if (operationName.equals(String.valueOf(OperationNames.TRANSFER))) {
            simpleLog = getTransferLog(request);
        }
        if (operationName.equals(String.valueOf(OperationNames.CONFIRM))) {
            simpleLog = getConfirmLog(request);
        }
        Files.write(Paths.get(fileToLogName), simpleLog.getBytes(), StandardOpenOption.APPEND);
    }
}
