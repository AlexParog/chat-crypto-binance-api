package com.application.binance.impl;

import com.application.binance.constant.BinanceApiConstants;
import com.application.binance.exception.BinanceApiError;
import com.application.binance.exception.BinanceApiException;
import com.application.binance.security.AuthenticationInterceptor;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;

/**
 * Генерирует реализацию Binance API на основе @see {@link BinanceApiService}.
 *
 * @author alexanderbibik
 */
public class BinanceApiServiceGenerator {

    /**
     * Экземпляр построителя OkHttpClient для создания клиента HTTP.
     */
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    /**
     * Экземпляр построителя Retrofit для создания экземпляра Retrofit.
     * Устанавливает базовый URL и конвертер Jackson для сериализации/десериализации JSON.
     */
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BinanceApiConstants.API_BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create());

    /**
     * Экземпляр Retrofit, созданный с помощью построителя Retrofit.
     * Используется для выполнения сетевых запросов к API.
     */
    private static Retrofit retrofit = builder.build();

    /**
     * Создает сервис для выполнения API-запросов без использования аутентификации.
     *
     * @param serviceClass класс сервиса
     * @param <S>          тип сервиса
     * @return экземпляр сервиса
     */
    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null, null);
    }

    /**
     * Создает сервис для выполнения API-запросов с использованием аутентификации.
     *
     * @param serviceClass класс сервиса
     * @param apiKey       API-ключ
     * @param secret       секретный ключ
     * @param <S>          тип сервиса
     * @return экземпляр сервиса
     */
    public static <S> S createService(Class<S> serviceClass, String apiKey, String secret) {
        if (!StringUtils.isEmpty(apiKey) && !StringUtils.isEmpty(secret)) {
            AuthenticationInterceptor interceptor = new AuthenticationInterceptor(apiKey, secret);
            if (!httpClient.interceptors().contains(interceptor)) {
                httpClient.addInterceptor(interceptor);
                builder.client(httpClient.build());
                retrofit = builder.build();
            }
        }
        return retrofit.create(serviceClass);
    }

    /**
     * Выполняет синхронный REST-запрос и блокирует выполнение до получения ответа.
     *
     * @param call объект типа Call<T>
     * @param <T>  тип данных ответа
     * @return объект типа T
     * @throws BinanceApiException если возникла ошибка при выполнении запроса
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                BinanceApiError apiError = getBinanceApiError(response);
                throw new BinanceApiException(apiError);
            }
        } catch (IOException e) {
            throw new BinanceApiException(e);
        }
    }

    /**
     * Извлекает и преобразует тело ошибки из ответа в объект типа BinanceApiError.
     *
     * @param response объект типа Response<?>
     * @return объект типа BinanceApiError
     * @throws IOException         если произошла ошибка ввода-вывода
     * @throws BinanceApiException если возникла ошибка при обработке ответа
     */
    public static BinanceApiError getBinanceApiError(Response<?> response) throws IOException, BinanceApiException {
        return (BinanceApiError) retrofit.responseBodyConverter(BinanceApiError.class, new Annotation[0])
                .convert(response.errorBody());
    }
}
