package ru.korteng.wallet.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class WalletRequest {
    private UUID walletId;
    private OperationType operationType;
    private BigDecimal amount;

    public enum OperationType {
        DEPOSIT,
        WITHDRAW
    }
}
