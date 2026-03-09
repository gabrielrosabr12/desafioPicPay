package com.application.picpay.controller;

import com.application.picpay.service.CreateWalletServivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

    private final CreateWalletServivce createWalletServivce;

    public WalletController(CreateWalletServivce createWalletServivce) {
        this.createWalletServivce = createWalletServivce;
    }
}
