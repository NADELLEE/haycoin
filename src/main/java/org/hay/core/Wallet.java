package org.hay.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hay.crypto.ECKey;
import org.hay.utils.ByteArray;
import org.hay.utils.Utils;

public class Wallet {
    private static final Logger logger = LoggerFactory.getLogger("wallet");

    private ECKey ecKey;
    private byte[] address;

    /**
     * get a new wallet key
     */
    public void init() {
        this.ecKey = new ECKey(Utils.getRandom());
        address = this.ecKey.getAddress();
    }

    /**
     * get a wallet by the key
     *
     * @param ecKey keypair
     */
    public void init(ECKey ecKey) {
        this.ecKey = ecKey;
        address = this.ecKey.getAddress();

        logger.info("wallet address: {}", ByteArray.toHexString(address));
    }

    public ECKey getEcKey() {
        return ecKey;
    }

    public void setEcKey(ECKey ecKey) {
        this.ecKey = ecKey;
    }

    public byte[] getAddress() {
        return address;
    }

    public void setAddress(byte[] address) {
        this.address = address;
    }
}
