package com.aleksandr.card_transfer.repository;

import com.aleksandr.card_transfer.exceptions.OperationIdNotFountErrorException;
import com.aleksandr.card_transfer.model.OperationInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class Repo {
    private HashMap<String, OperationInfo> db = new HashMap<>();

    public void add(String operationId, OperationInfo operationInfo) {
        db.put(operationId, operationInfo);
    }

    public void updateByCode(String operationId, String code) {
        if (db.get(operationId) == null) {
            throw new OperationIdNotFountErrorException();
        }
        OperationInfo operationInfo = db.get(operationId);
        operationInfo.setCode(code);
        db.put(operationId, operationInfo);
    }
}
