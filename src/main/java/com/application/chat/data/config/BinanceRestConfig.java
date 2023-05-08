package com.application.chat.data.config;

import com.application.chat.data.provider.BinanceSettingsProvider;
import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Класс конфигурации, который предоставляет Bean REST-клиента Binance API, используя предоставленный ключ API и
 * секретный ключ из экземпляра {@link BinanceSettingsProvider}
 *
 * @author alexanderbibik
 */
@Configuration
@AllArgsConstructor
public class BinanceRestConfig {

    /**
     * API-ключ и секретный ключ.
     */
    private final BinanceSettingsProvider settingsProvider;

    /**
     * Bean, создающий новый экземпляр REST-клиента Binance API с предоставленными ключом API и секретным ключом.
     *
     * @return {@link BinanceApiRestClient} экземпляр
     */
    @Bean
    public BinanceApiRestClient binanceApiRestClient() {
        return BinanceApiClientFactory.newInstance(settingsProvider.getApiKey(),
                settingsProvider.getSecretKey()).newRestClient();
    }

}
