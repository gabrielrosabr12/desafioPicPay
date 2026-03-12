package com.application.picpay.service;

import com.application.picpay.client.dto.TransferDto;
import com.application.picpay.entity.Transfer;
import com.application.picpay.entity.Wallet;
import com.application.picpay.exception.InsufficientBalanceException;
import com.application.picpay.exception.TransferNotAllowedForWalletTypeException;
import com.application.picpay.exception.TransferNotAuthorizedException;
import com.application.picpay.exception.WalletNotFoundException;
import com.application.picpay.repository.TransferRepository;
import com.application.picpay.repository.WalletRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

@Service
public class TransferService {

    private final TransferRepository transferRepository;
    private final AuthorizationService authorizationService;
    private final NotificationService notificationService;
    private final WalletRepository walletRepository;

    public TransferService(TransferRepository transferRepository,
                           AuthorizationService authorizationService,
                           NotificationService notificationService,
                           WalletRepository walletRepository) {
        this.transferRepository = transferRepository;
        this.authorizationService = authorizationService;
        this.notificationService = notificationService;
        this.walletRepository = walletRepository;
    }

    @Transactional
    public Transfer transfer(TransferDto dto){
        var sender = walletRepository.findById(dto.payer())
                .orElseThrow(()  -> new WalletNotFoundException(dto.payer()));

        var receiver = walletRepository.findById(dto.payee())
                .orElseThrow(()  -> new WalletNotFoundException(dto.payee()));

        validateTransfer(dto,sender);

        sender.debit(dto.value());
        receiver.credit(dto.value());

        var transfer = new Transfer(sender,receiver,dto.value());

        walletRepository.save(sender);
        walletRepository.save(receiver);
        var transferResult = transferRepository.save(transfer);

        CompletableFuture.runAsync(() -> notificationService.sendNotification(transferResult));

        return transferResult;
    }

    private void validateTransfer(TransferDto dto, Wallet sender){

        if (!sender.isTransferAllowedForWalletType()){
            throw new TransferNotAllowedForWalletTypeException();
        }

        if (!sender.isBalanceEqualOrGreatherThan(dto.value())){
            throw new InsufficientBalanceException();
        }

        if (!authorizationService.isAuthorized(dto)){
            throw new TransferNotAuthorizedException();
        }


    }
}
