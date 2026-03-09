package com.application.picpay.service;

import com.application.picpay.controller.dto.WalletDTO;
import com.application.picpay.entity.Wallet;
import com.application.picpay.entity.WalletType;
import com.application.picpay.repository.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateWalletServivce {

    private final WalletRepository walletRepository;

    public CreateWalletServivce(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(WalletDTO walletDTO) {

        var walletDb = walletRepository.findByCpfCnpjOrEmail(walletDTO.cpfCnpj(),walletDTO.email());

        if (walletDb.isPresent()) {

        }

        return walletRepository.save(walletDTO.toWallet());
    }

}
