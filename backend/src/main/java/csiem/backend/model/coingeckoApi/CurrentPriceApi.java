package csiem.backend.model.coingeckoApi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CurrentPriceApi {

    private int usd;
    private int eur;
}
