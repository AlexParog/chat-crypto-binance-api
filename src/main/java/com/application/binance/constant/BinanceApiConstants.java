package com.application.binance.constant;

/**
 * Константы, используемые в API Binance.
 *
 * @author alexanderbibik
 */
public class BinanceApiConstants {

    /**
     * Базовый URL REST API.
     */
    public static final String API_BASE_URL = "https://api.binance.com";

    /**
     * HTTP-заголовок, используемый для аутентификации с помощью API-ключа.
     */
    public static final String API_KEY_HEADER = "X-MBX-APIKEY";

    /**
     * Декоратор, указывающий, что для конечной точки требуется API-ключ.
     */
    public static final String ENDPOINT_SECURITY_TYPE_APIKEY = "APIKEY";
    public static final String ENDPOINT_SECURITY_TYPE_APIKEY_HEADER = ENDPOINT_SECURITY_TYPE_APIKEY + ": #";

    /**
     * Декоратор, указывающий, что для конечной точки требуется подпись.
     */
    public static final String ENDPOINT_SECURITY_TYPE_SIGNED = "SIGNED";
    public static final String ENDPOINT_SECURITY_TYPE_SIGNED_HEADER = ENDPOINT_SECURITY_TYPE_SIGNED + ": #";

    /**
     * По умолчанию окно получения.
     */
    public static final long DEFAULT_RECEIVING_WINDOW = 6_000_000L;
}
