package com.application.picpay.controller.dto;

import com.application.picpay.entity.Wallet;
import com.application.picpay.entity.WalletType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record WalletDTO(@NotBlank String fullName,
                        @NotBlank String cpfCnpj,
                        @NotBlank String email,
                        @NotBlank String password,
                        @NotNull WalletType.Enum walletType) {


    public Wallet toWallet(){
        return new Wallet(fullName, cpfCnpj, email, password, walletType.get());
    }
}
