package mini.wallet.monolith.service.user;

import mini.wallet.monolith.builder.WalletBuilder;
import mini.wallet.monolith.dal.dataobject.WalletDO;
import mini.wallet.monolith.dal.repository.WalletRepository;
import mini.wallet.monolith.model.Wallet;
import mini.wallet.monolith.model.request.WalletRegisterRequest;
import mini.wallet.monolith.model.response.WalletRegisterResponse;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public WalletRegisterResponse register(WalletRegisterRequest walletRegisterRequest) {
        WalletDO walletDO = WalletBuilder.buildWalletDOFromWalletRegisterRequest(walletRegisterRequest);
        walletRepository.save(walletDO);

        Wallet wallet = WalletBuilder.buildWalletFromWalletDO(walletDO);

        WalletRegisterResponse walletRegisterResponse = new WalletRegisterResponse();
        walletRegisterResponse.setWallet(wallet);

        return walletRegisterResponse;
    }
}
