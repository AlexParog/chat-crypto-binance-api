package com.application.binance.domain.market;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * Десериализатор для OrderBookEntry, так как API возвращает массив в формате [цена, количество, []].
 */
public class OrderBookEntryDeserializer extends JsonDeserializer<OrderBookEntry> {

    /**
     * Метод десериализации для OrderBookEntry.
     *
     * @param jp  JsonParser объект для чтения JSON данных.
     * @param ctx DeserializationContext объект, предоставляющий контекст десериализации.
     * @return OrderBookEntry объект, созданный из десериализованных данных.
     * @throws IOException Исключение, которое может возникнуть при чтении JSON данных.
     */
    @Override
    public OrderBookEntry deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
        ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);
        final String price = node.get(0).asText();
        final String qty = node.get(1).asText();

        OrderBookEntry orderBookEntry = new OrderBookEntry();
        orderBookEntry.setPrice(price);
        orderBookEntry.setQty(qty);
        return orderBookEntry;
    }
}
