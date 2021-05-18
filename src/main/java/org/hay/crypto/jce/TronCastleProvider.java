package org.hay.crypto.jce;

import org.spongycastle.jce.provider.BouncyCastleProvider;

import java.security.Provider;
import java.security.Security;

public final class hayCastleProvider {

    private static class Holder {
        private static final Provider INSTANCE;

        static {
            Provider p = Security.getProvider("SC");

            INSTANCE = (p != null) ? p : new BouncyCastleProvider();

            INSTANCE.put("MessageDigest.hay-KECCAK-256", "org.hay.crypto" +
                    ".cryptohash.Keccak256");
            INSTANCE.put("MessageDigest.hay-KECCAK-512", "org.hay.crypto" +
                    ".cryptohash.Keccak512");
        }
    }

    public static Provider getInstance() {
        return Holder.INSTANCE;
    }
}
