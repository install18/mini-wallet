package mini.wallet.monolith.service;

import lombok.AllArgsConstructor;
import mini.wallet.monolith.dal.dataobject.WalletDO;
import mini.wallet.monolith.dal.repository.WalletDAO;
import mini.wallet.monolith.helper.builder.WalletBuilder;
import mini.wallet.monolith.model.Wallet;
import mini.wallet.monolith.model.request.WalletCreateOrderRequest;
import mini.wallet.monolith.model.request.WalletRegisterRequest;
import mini.wallet.monolith.model.response.WalletCreateOrderResponse;
import mini.wallet.monolith.model.response.WalletRegisterResponse;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WalletService {
    private final WalletDAO walletDAO;

    public WalletRegisterResponse register(WalletRegisterRequest walletRegisterRequest) {
        WalletDO walletDO = WalletBuilder.buildWalletDOFromWalletRegisterRequest(walletRegisterRequest);
        walletDAO.save(walletDO);

        Wallet wallet = WalletBuilder.buildWalletFromWalletDO(walletDO);

        WalletRegisterResponse walletRegisterResponse = new WalletRegisterResponse();
        walletRegisterResponse.setWallet(wallet);

        return walletRegisterResponse;
    }

    public WalletCreateOrderResponse createOrder(WalletCreateOrderRequest walletCreateOrderRequest) {
        WalletCreateOrderResponse walletCreateOrderResponse = new WalletCreateOrderResponse();



        return walletCreateOrderResponse;
    }

}
