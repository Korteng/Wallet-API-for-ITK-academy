package ru.korteng.wallet.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import ru.korteng.wallet.model.Wallet;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class WalletRepositoryTest {

    @Autowired
    private WalletRepository walletRepository;

    @Test
    void findById_shouldReturnWallet() {
        UUID walletId = UUID.randomUUID();
        Wallet wallet = new Wallet(walletId, new BigDecimal("1000.00"));

        walletRepository.save(wallet);
        Optional<Wallet> found = walletRepository.findById(walletId);

        assertTrue(found.isPresent());
        assertEquals(walletId, found.get().getId());
    }
}