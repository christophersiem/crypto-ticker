package csiem.backend.service.factory;

import csiem.backend.model.Coin;
import csiem.backend.model.CurrentPrice;
import csiem.backend.model.coingeckoApi.CoinApi;
import csiem.backend.model.coingeckoApi.CurrentPriceApi;
import org.springframework.stereotype.Service;

@Service
public class CoinFactory {

    public Coin mapToCoin(CoinApi coinApi){
        CurrentPriceApi currentPriceApi = coinApi.getMarketData().getCurrentPrice();
        return Coin
                .builder()
                .name(coinApi.getName())
                .currentPrice(CurrentPrice
                        .builder()
                        .eur(currentPriceApi.getEur())
                        .usd(currentPriceApi.getUsd())
                        .build()
                )
                .imageUrl(coinApi.getImage().getImageUrl())
                .build();
    }
}
