package com.ddnshop.oauthservice.ecdh;

import com.ddnshop.oauthservice.util.ApplicationUtils;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecP256K1Curve;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Sign;

import javax.crypto.KeyAgreement;
import java.math.BigInteger;
import java.security.*;

/**
 * y^2 đồng dư x^3 + ax + b
 * y^2 đồng dư x^3 + 7 (voi a = 0,b = 7)
 *
 */
@Service
public class ECDHProvider {

    public PublicKey generatePublicKey() throws Exception {
        ECCurve curve = new SecP256K1Curve();

        BigInteger private_key= ApplicationUtils.getInstance().randomBigInteger(curve.getOrder());

        ECPoint public_key = Sign.publicPointFromPrivate(private_key);

        return ApplicationUtils.getInstance().loadPublicKey(public_key.getEncoded(true));
    }

    public PrivateKey generatePrivateKey() throws Exception {
        ECCurve curve = new SecP256K1Curve();

        BigInteger private_key = ApplicationUtils.getInstance().randomBigInteger(curve.getOrder());

        PrivateKey privateKey = ApplicationUtils.getInstance().loadPrivateKey(private_key);
        return privateKey;
//        return ApplicationUtils.getInstance().loadPrivateKey(private_key);
    }


}