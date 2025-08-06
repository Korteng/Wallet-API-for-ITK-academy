package ru.korteng.wallet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.korteng.wallet.dto.WalletRequest;
import ru.korteng.wallet.dto.WalletResponse;
import ru.korteng.wallet.exception.WalletNotFoundException;
import ru.korteng.wallet.model.Wallet;
import ru.korteng.wallet.repository.WalletRepository;

import static ru.korteng.wallet.dto.WalletRequest.OperationType.DEPOSIT;

@Service
@Transactional
public class WalletService {
    private final WalletRepository repository;

    public WalletResponse createOperation (WalletRequest request) {
        Wallet wallet = repository.findByIdForUpdate(request.getId())
                .orElseThrow(() -> new WalletNotFoundException(request.getId()));
        if (request.getOperationType() == DEPOSIT) {
            wallet.deposit(request.getAmount());
        } else {
            wallet.withdraw(request.getAmount());
        }
        repository.save(wallet);
        return new WalletResponse(wallet.getId(), wallet.getBalance());
    }

    public WalletService(WalletRepository repository) {
        this.repository = repository;
    }
}
