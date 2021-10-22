package csiem.backend.model.coingeckoApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrentPriceApi {

    private int usd;
    private int eur;
}
