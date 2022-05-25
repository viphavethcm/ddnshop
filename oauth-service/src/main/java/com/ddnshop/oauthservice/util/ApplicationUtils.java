package com.ddnshop.oauthservice.util;

import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.spec.ECPrivateKeySpec;
import org.bouncycastle.jce.spec.ECPublicKeySpec;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Random;

public class ApplicationUtils {
    static final char[] hexArray = "0123456789abcdef".toCharArray();

    public static ApplicationUtils applicationUtils;

    public static synchronized ApplicationUtils getInstance()
    {
        if (applicationUtils == null)
            applicationUtils = new ApplicationUtils();

        return applicationUtils;
    }
    public BigInteger randomBigInteger(BigInteger n) {
        Random rnd = new Random();
        int maxNumBitLength = n.bitLength();
        BigInteger aRandomBigInt;
        do {
            aRandomBigInt = new BigInteger(maxNumBitLength, rnd);
            // compare random number lessthan ginven number
        } while (aRandomBigInt.compareTo(n) > 0);
        return aRandomBigInt;
    }

    public PublicKey loadPublicKey (byte [] data) throws Exception
    {
        ECParameterSpec params = ECNamedCurveTable.getParameterSpec("secp256k1");
        ECPublicKeySpec pubKey = new ECPublicKeySpec(params.getCurve().decodePoint(data),params);
        KeyFactory kf = KeyFactory.getInstance("ECDH","BC");
        return kf.generatePublic(pubKey);
    }

    public PrivateKey loadPrivateKey (BigInteger privateKey) throws Exception
    {
        ECParameterSpec params = ECNamedCurveTable.getParameterSpec("secp256k1");
        ECPrivateKeySpec prvkey = new ECPrivateKeySpec(privateKey, params);
        KeyFactory kf = KeyFactory.getInstance("ECDH","BC");
        return kf.generatePrivate(prvkey);
    }

    public String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
