package ru.korteng.wallet.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.korteng.wallet.dto.WalletRequest;
import ru.korteng.wallet.dto.WalletResponse;
import ru.korteng.wallet.service.WalletService;

@RestController
@RequestMapping("api/v1/wallet")
public class WalletController {
    private final WalletService service;

    public WalletController(WalletService service) {
        this.service = service;
    }

    @PostMapping("/balance")
    public ResponseEntity<WalletResponse> updateBalance (@Valid @RequestBody WalletRequest request) {

        return ResponseEntity.ok(service.createOperation(request));
    }
}
