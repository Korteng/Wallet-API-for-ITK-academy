package ru.korteng.wallet.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

public class WalletRequest {

    @NotNull
    private UUID id;

    @NotNull
    private OperationType operationType;

    @Positive
    private BigDecimal amount;

    public enum OperationType {
        DEPOSIT,
        WITHDRAW
    }

    public @NotNull UUID getId() {
        return id;
    }

    public void setId(@NotNull UUID id) {
        this.id = id;
    }

    public @NotNull OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(@NotNull OperationType operationType) {
        this.operationType = operationType;
    }

    public @Positive BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(@Positive BigDecimal amount) {
        this.amount = amount;
    }
}
