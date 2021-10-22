package csiem.backend.service.factory;

import csiem.backend.model.Coin;
import csiem.backend.model.CurrentPrice;
import csiem.backend.model.coingeckoApi.CoinApi;
import org.springframework.stereotype.Service;

@Service
public class CoinFactory {

    public Coin mapToCoin(CoinApi coinApi){
        return Coin
                .builder()
                .name(coinApi.getName())
                .currentPrice(CurrentPrice
                        .builder()
                        .eur(coinApi.getMarketdata().getCurrentPrice().getEur())
                        .usd(coinApi.getMarketdata().getCurrentPrice().getUsd())
                        .build()
                )
                .build();
    }
}
