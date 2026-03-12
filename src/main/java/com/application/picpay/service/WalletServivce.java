package com.application.picpay.service;

import com.application.picpay.controller.dto.WalletDTO;
import com.application.picpay.entity.Wallet;
import com.application.picpay.exception.WalletDataAlreadyExistsExceptiom;
import com.application.picpay.repository.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletServivce {

    private final WalletRepository walletRepository;

    public WalletServivce(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(WalletDTO walletDTO) {

        var walletDb = walletRepository.findByCpfCnpjOrEmail(walletDTO.cpfCnpj(),walletDTO.email());

        if (walletDb.isPresent()) {
            throw new WalletDataAlreadyExistsExceptiom("CpfCnpj or Email already exists");
        }
        return walletRepository.save(walletDTO.toWallet());
    }

}
