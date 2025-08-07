package ru.korteng.wallet.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.korteng.wallet.dto.WalletRequest;
import ru.korteng.wallet.dto.WalletResponse;
import ru.korteng.wallet.model.Wallet;
import ru.korteng.wallet.service.WalletService;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ru.korteng.wallet.dto.WalletRequest.OperationType.DEPOSIT;
import org.springframework.http.MediaType;

public class WalletControllerTest {

    private MockMvc mockMvc;
    private final WalletService walletService = mock(WalletService.class);

    @BeforeEach
    void setUp() {
        WalletController controller = new WalletController(walletService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getBalance_shouldReturn200() throws Exception {
        // 1. Подготовка данных
        UUID walletId = UUID.randomUUID();
        Wallet wallet = new Wallet(walletId, new BigDecimal("1000.00"));

        // 2. Настройка моков
        when(walletService.getWallet(walletId)).thenReturn(wallet);

        // 3. Вызов и проверка
        mockMvc.perform(get("/api/v1/wallet/wallets/{walletId}", walletId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(walletId.toString()))
                .andExpect(jsonPath("$.newBalance").value(1000.00));
    }
}