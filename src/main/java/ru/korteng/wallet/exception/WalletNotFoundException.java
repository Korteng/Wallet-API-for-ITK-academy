package ru.korteng.wallet.exception;

import java.util.UUID;

public class WalletNotFoundException extends RuntimeException{
    public WalletNotFoundException (UUID message) {
        super(String.valueOf(message));
    }
}
