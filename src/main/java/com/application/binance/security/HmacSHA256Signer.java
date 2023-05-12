package com.application.binance.security;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Утилитный класс для подписи сообщений с использованием HMAC-SHA256.
 *
 * @author alexanderbibik
 */
public class HmacSHA256Signer {

    /**
     * Подписывает указанное сообщение с использованием указанного секретного ключа.
     *
     * @param message сообщение для подписи
     * @param secret  секретный ключ
     * @return подписанное сообщение
     */

    public static String sign(String message, String secret) {
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secretKeySpec);
            return Hex.encodeHexString(sha256_HMAC.doFinal(message.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("Невозможно подписать сообщение.", e);
        }
    }
}
