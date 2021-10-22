package csiem.backend.model.coingeckoApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoinApi {
    String id;
    String name;
    @JsonProperty("market_data")
    MarketDataApi marketdata;
}
