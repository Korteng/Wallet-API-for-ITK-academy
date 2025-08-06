package ru.korteng.wallet.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

public class WalletResponse {
    private UUID id;
    private BigDecimal newBalance;

    public WalletResponse(UUID id, BigDecimal newBalance) {
        this.id = id;
        this.newBalance = newBalance;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(BigDecimal newBalance) {
        this.newBalance = newBalance;
    }
}
