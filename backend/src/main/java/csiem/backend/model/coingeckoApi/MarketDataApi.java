package csiem.backend.model.coingeckoApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MarketDataApi {

   @JsonProperty("current_price")
   private CurrentPriceApi currentPrice;
}
