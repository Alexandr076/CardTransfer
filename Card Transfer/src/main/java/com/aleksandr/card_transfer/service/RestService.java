package com.aleksandr.card_transfer.service;

import com.aleksandr.card_transfer.OperationNames;
import com.aleksandr.card_transfer.integrationModel.ConfirmReq;
import com.aleksandr.card_transfer.log.Log;
import com.aleksandr.card_transfer.model.OperationInfo;
import com.aleksandr.card_transfer.integrationModel.Response;
import com.aleksandr.card_transfer.integrationModel.TransferReq;
import com.aleksandr.card_transfer.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RestService {
    @Autowired
    private Repo repo;

    @Autowired
    private Log logger;

    public ResponseEntity<Response> transfer(TransferReq transferReq) {
        String operationId = String.valueOf(UUID.randomUUID());
        Response response = new Response(operationId);
        OperationInfo operationInfo = new OperationInfo(transferReq);
        repo.add(String.valueOf(operationId), operationInfo);
        try {
            logger.toLogFile(transferReq, String.valueOf(OperationNames.TRANSFER));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Response> confirmOperation(ConfirmReq confirmReq) {
        repo.updateByCode(confirmReq.getOperationId(), confirmReq.getCode());
        Response response = new Response(confirmReq.getOperationId());
        try {
            logger.toLogFile(confirmReq, String.valueOf(OperationNames.CONFIRM));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
