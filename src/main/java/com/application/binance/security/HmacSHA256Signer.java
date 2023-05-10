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
    /*
    Класс HmacSHA256Signer представляет утилиту для подписи сообщений с использованием алгоритма HMAC-SHA256.
    HMAC (Hash-based Message Authentication Code) - это метод аутентификации сообщений, который использует хэш-функцию в сочетании
    с секретным ключом.

Принцип работы метода sign в данном классе заключается в следующем:

Создается экземпляр объекта Mac с использованием алгоритма HMAC-SHA256.
Создается экземпляр SecretKeySpec для передачи секретного ключа в алгоритм HMAC-SHA256.
Инициализируется Mac с использованием SecretKeySpec.
Вычисляется подпись для указанного сообщения, вызывая метод doFinal на объекте Mac. Результат представляет собой байтовый массив.
Полученный байтовый массив преобразуется в строку в шестнадцатеричном формате с помощью метода encodeHexString из класса Hex.
Возвращается подписанное сообщение в виде строки.
Алгоритм HMAC-SHA256 использует хэш-функцию SHA-256 (Secure Hash Algorithm 256-bit) в сочетании с ключом для создания
подписи сообщения. HMAC-SHA256 обеспечивает целостность и аутентификацию сообщения, так как подпись будет различной при изменении даже
одного символа в сообщении или ключе.

Применение HMAC-SHA256 в данном контексте позволяет обеспечить безопасность и подлинность передаваемых данных, особенно
при взаимодействии с API, где требуется подписывать запросы с использованием секретного ключа для проверки их подлинности со
стороны сервера.
     */
    public static String sign(String message, String secret) {
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secretKeySpec);
            return Hex.encodeHexString(sha256_HMAC.doFinal(message.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("Unable to sign message.", e);
        }
    }
}
