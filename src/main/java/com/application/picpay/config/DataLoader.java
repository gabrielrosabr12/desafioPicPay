package com.application.picpay.config;

import com.application.picpay.entity.WalletType;
import com.application.picpay.exception.WalletDataAlreadyExistsExceptiom;
import com.application.picpay.repository.WalletTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final WalletTypeRepository walletTypeRepository;

    public DataLoader(WalletTypeRepository walletTypeRepository) {
        this.walletTypeRepository = walletTypeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(WalletType.Enum.values())
                .forEach(walletType -> {
                    walletTypeRepository.findById(walletType.get().getId())
                            .ifPresentOrElse(wallet -> {
                        System.out.println("Wallet "+wallet+" was found");},
                                    ()-> {
                        walletTypeRepository.save(walletType.get());
                            }
                            );
                });

    }
}