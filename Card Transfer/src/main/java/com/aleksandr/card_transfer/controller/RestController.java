package com.aleksandr.card_transfer.controller;

import com.aleksandr.card_transfer.integrationModel.ConfirmReq;
import com.aleksandr.card_transfer.integrationModel.Response;
import com.aleksandr.card_transfer.integrationModel.TransferReq;
import com.aleksandr.card_transfer.service.RestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    RestService restService;

    @PostMapping("/transfer")
    public ResponseEntity<Response> transfer(@Valid @RequestBody TransferReq transferReq) {
        return restService.transfer(transferReq);
    }

    @PostMapping("/confirmOperation")
    public ResponseEntity<Response> confirmOperation(@Valid @RequestBody ConfirmReq confirmReq, WebRequest webRequest) {
        webRequest.setAttribute("confirmReq", confirmReq, RequestAttributes.SCOPE_REQUEST);
        return restService.confirmOperation(confirmReq);
    }
}