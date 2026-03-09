package com.application.picpay.controller.dto;

import com.application.picpay.entity.Wallet;
import com.application.picpay.entity.WalletType;

public record WalletDTO(String fullName,
                        String cpfCnpj,
                        String email,
                        String password,
                        WalletType.Enum walletType) {

    public Wallet toWallet(){
        return new Wallet(fullName, cpfCnpj, email, password, walletType.get());
    }
}
