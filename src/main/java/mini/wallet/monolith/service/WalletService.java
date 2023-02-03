package mini.wallet.monolith.service;

import mini.wallet.monolith.dal.dataobject.WalletDO;
import mini.wallet.monolith.dal.repository.WalletDAO;
import mini.wallet.monolith.helper.builder.WalletBuilder;
import mini.wallet.monolith.model.Wallet;
import mini.wallet.monolith.model.request.WalletRegisterRequest;
import mini.wallet.monolith.model.response.WalletRegisterResponse;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    private final WalletDAO walletDAO;

    public WalletService(WalletDAO walletDAO) {
        this.walletDAO = walletDAO;
    }

    public WalletRegisterResponse register(WalletRegisterRequest walletRegisterRequest) {
        WalletDO walletDO = WalletBuilder.buildWalletDOFromWalletRegisterRequest(walletRegisterRequest);
        walletDAO.save(walletDO);

        Wallet wallet = WalletBuilder.buildWalletFromWalletDO(walletDO);

        WalletRegisterResponse walletRegisterResponse = new WalletRegisterResponse();
        walletRegisterResponse.setWallet(wallet);

        return walletRegisterResponse;
    }
}
