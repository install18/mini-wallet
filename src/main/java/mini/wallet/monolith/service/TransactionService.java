package mini.wallet.monolith.service;

import lombok.AllArgsConstructor;
import mini.wallet.monolith.dal.dataobject.TransactionDO;
import mini.wallet.monolith.model.request.CreateTransactionRequest;
import mini.wallet.monolith.model.response.CreateTransactionResponse;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionService {
    private TransactionDO transactionDO;

    public CreateTransactionResponse create(CreateTransactionRequest request) {
        CreateTransactionResponse response = new CreateTransactionResponse();

        return response;
    }
}
