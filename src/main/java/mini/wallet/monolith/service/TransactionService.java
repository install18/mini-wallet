package mini.wallet.monolith.service;

import lombok.AllArgsConstructor;
import mini.wallet.monolith.dal.dataobject.TransactionDO;
import mini.wallet.monolith.model.request.TransactionCreateOrderRequest;
import mini.wallet.monolith.model.response.TransactionCreateOrderResponse;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionService {
    private TransactionDO transactionDO;

    public TransactionCreateOrderResponse createOrder(TransactionCreateOrderRequest request) {
        TransactionCreateOrderResponse response = new TransactionCreateOrderResponse();

        return response;
    }
}
