package mini.wallet.monolith.helper.builder;

import mini.wallet.monolith.dal.dataobject.WalletDO;
import mini.wallet.monolith.model.Wallet;
import mini.wallet.monolith.model.request.WalletRegisterRequest;

import java.util.UUID;

public class WalletBuilder {
    public static WalletDO buildWalletDOFromWalletRegisterRequest(WalletRegisterRequest walletRegisterRequest) {
        WalletDO walletDO = new WalletDO();

        walletDO.setWalletId(UUID.randomUUID().toString());
        walletDO.setCustomerId(walletRegisterRequest.getCustomerId());
        walletDO.setBalance("0");

        return walletDO;
    }

    public static Wallet buildWalletFromWalletDO(WalletDO walletDO) {
        Wallet wallet = new Wallet();

        wallet.setWalletId(walletDO.getWalletId());
        wallet.setBalance(walletDO.getBalance());

        return wallet;
    }
}
