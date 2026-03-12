package com.application.picpay.controller;

import com.application.picpay.controller.dto.WalletDTO;
import com.application.picpay.entity.Wallet;
import com.application.picpay.service.WalletServivce;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

    private final WalletServivce createWalletServivce;

    public WalletController(WalletServivce createWalletServivce) {
        this.createWalletServivce = createWalletServivce;
    }

    @PostMapping("/wallets")
    public ResponseEntity<Wallet> createWallet(@RequestBody @Valid WalletDTO walletDTO) {
        var wallet =  createWalletServivce.createWallet(walletDTO);

        return ResponseEntity.ok(wallet);
    }


}
