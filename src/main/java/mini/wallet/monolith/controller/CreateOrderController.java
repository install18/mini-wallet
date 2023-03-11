package mini.wallet.monolith.controller;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mini.wallet.monolith.model.request.CreateOrderRequest;
import mini.wallet.monolith.model.request.TransactionCreateOrderRequest;
import mini.wallet.monolith.model.request.WalletCreateOrderRequest;
import mini.wallet.monolith.model.response.CreateOrderResponse;
import mini.wallet.monolith.model.response.TransactionCreateOrderResponse;
import mini.wallet.monolith.model.response.WalletCreateOrderResponse;
import mini.wallet.monolith.service.TransactionService;
import mini.wallet.monolith.service.WalletService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class CreateOrderController {
    private TransactionService transactionService;
    private WalletService walletService;

    @Transactional
    public CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest) {
        CreateOrderResponse createOrderResponse = new CreateOrderResponse();

        TransactionCreateOrderRequest transactionCreateRequest = buildTransactionCreateOrderRequest(createOrderRequest);
        TransactionCreateOrderResponse transactionCreateResponse = transactionService.createOrder(transactionCreateRequest);

        WalletCreateOrderRequest walletCreateOrderRequest = buildWalletCreateOrderRequest(transactionCreateResponse);
        WalletCreateOrderResponse walletCreateOrderResponse = walletService.createOrder(walletCreateOrderRequest);

        return createOrderResponse;
    }

    private TransactionCreateOrderRequest buildTransactionCreateOrderRequest(CreateOrderRequest createOrderRequest) {
        TransactionCreateOrderRequest transactionCreateOrderRequest = new TransactionCreateOrderRequest();

        BeanUtils.copyProperties(createOrderRequest, transactionCreateOrderRequest);

        return transactionCreateOrderRequest;
    }

    private WalletCreateOrderRequest buildWalletCreateOrderRequest(TransactionCreateOrderResponse transactionCreateOrderResponse) {
        WalletCreateOrderRequest walletCreateOrderRequest = new WalletCreateOrderRequest();

        return walletCreateOrderRequest;
    }
}
