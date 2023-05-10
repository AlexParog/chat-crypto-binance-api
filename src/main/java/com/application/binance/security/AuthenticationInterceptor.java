package com.application.binance.security;

import com.application.binance.constant.BinanceApiConstants;
import okhttp3.*;
import okio.Buffer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * Перехватчик запросов, который внедряет заголовок с API-ключом в запросы и подписывает сообщения, при необходимости.
 *
 * @author alexanderbibik
 */
public class AuthenticationInterceptor implements Interceptor {

    private final String apiKey;

    private final String secret;

    /**
     * Конструктор класса.
     *
     * @param apiKey API-ключ
     * @param secret секретный ключ
     */
    public AuthenticationInterceptor(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
    }

    /**
     * Перехватывает запрос и выполняет аутентификацию и проверку подписи, если это требуется.
     *
     * @param chain цепочка перехватчиков для запроса
     * @return ответ, полученный после обработки перехваченного запроса
     * @throws IOException если возникает ошибка ввода-вывода во время перехвата
     */

    /*
    Данный метод intercept является частью перехватчика запросов (interceptor) в библиотеке. Он предназначен для выполнения
     аутентификации и проверки подписи перед отправкой запроса на сервер.

Принцип работы метода следующий:

Получается исходный запрос (original) из цепочки перехватчиков (chain).
Создается новый строитель запроса (newRequestBuilder) на основе исходного запроса.
Проверяется, требуется ли отправка действительного API-ключа (isApiKeyRequired) или проверка подписи (isSignatureRequired),
опираясь на заголовки исходного запроса.
Если требуется отправка API-ключа или проверка подписи, соответствующие заголовки добавляются в новый строитель запроса.
Если требуется проверка подписи, выполняется следующее:
a. Получается пакет данных для подписи из URL-адреса исходного запроса.
b. Если пакет данных не пустой, генерируется подпись с использованием метода HmacSHA256Signer.sign, передавая пакет данных
и секретный ключ (secret).
c. Создается новый URL-адрес с добавленным параметром "signature", содержащим сгенерированную подпись.
d. Обновляется URL-адрес нового строителя запроса с новым подписанным URL-адресом.
Создается новый запрос (newRequest) на основе нового строителя запроса.
Новый запрос отправляется на сервер с помощью метода proceed цепочки перехватчиков (chain).
Полученный ответ возвращается из метода.
Таким образом, метод intercept выполняет добавление необходимой аутентификационной информации (API-ключа) и подписи
(если требуется) к исходному запросу перед его отправкой на сервер. Это обеспечивает безопасность и аутентичность запросов
к Binance API.
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder newRequestBuilder = original.newBuilder();

        boolean isApiKeyRequired = original.header(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY) != null;
        boolean isSignatureRequired = original.header(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED) != null;
        newRequestBuilder.removeHeader(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED)
                .removeHeader(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED);

        // Требуется отправка действительного API-ключа
        if (isApiKeyRequired || isSignatureRequired) {
            newRequestBuilder.addHeader(BinanceApiConstants.API_KEY_HEADER, apiKey);
        }

        // Требуется подписание пакета данных
        if (isSignatureRequired) {
            String payload = original.url().query();
            if (!StringUtils.isEmpty(payload)) {
                String signature = HmacSHA256Signer.sign(payload, secret);
                HttpUrl signedUrl = original.url().newBuilder().addQueryParameter("signature", signature).build();
                newRequestBuilder.url(signedUrl);
            }
        }

        // Создание нового запроса после добавления необходимой информации для аутентификации
        Request newRequest = newRequestBuilder.build();
        return chain.proceed(newRequest);
    }

    /**
     * Извлекает тело запроса в виде строки.
     *
     * @param request объект типа RequestBody
     * @return тело запроса в виде строки
     */
    private static String bodyToString(RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null) {
                copy.writeTo(buffer);
            } else {
                return "";
            }
            return buffer.readUtf8();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
