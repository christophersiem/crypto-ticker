package csiem.backend.model.coingeckoApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketDataApi {

   @JsonProperty("current_price")
   private CurrentPriceApi currentPrice;
}
