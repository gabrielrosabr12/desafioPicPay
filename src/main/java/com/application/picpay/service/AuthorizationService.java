package com.application.picpay.service;

import com.application.picpay.client.AuthorizationClient;
import com.application.picpay.client.dto.TransferDto;
import com.application.picpay.entity.Transfer;
import com.application.picpay.exception.PicPayException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(TransferDto transferDto) {

        var resp = authorizationClient.isAuthorized();

        if (resp.getStatusCode().isError()) {
            throw new PicPayException();
        }

        return resp.getBody().sucess();
    }
}
