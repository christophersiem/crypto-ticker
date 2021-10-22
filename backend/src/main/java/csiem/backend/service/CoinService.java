package csiem.backend.service;

import csiem.backend.model.Coin;
import csiem.backend.model.coingeckoApi.CoinApi;
import csiem.backend.service.coingeckoApi.CoinGeckoApiService;
import csiem.backend.service.factory.CoinFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class CoinService {
    private final CoinGeckoApiService apiService;
    private final CoinFactory coinFactory;

    @Autowired
    public CoinService(CoinGeckoApiService apiService, CoinFactory coinFactory) {
        this.apiService = apiService;
        this.coinFactory = coinFactory;
    }

    public Coin getCoinDataById(String coinId) {
        CoinApi coinApi = apiService.getCoinInfoById(coinId)
                .orElseThrow(()-> new NoSuchElementException("Coin data for " + coinId + "could not get loaded from Coingecko"));
        return coinFactory.mapToCoin(coinApi);

    }

    public List<Coin> getStandardCoins() {
        Coin bitcoinData = coinFactory.mapToCoin(apiService.getCoinInfoById("bitcoin").get());
        Coin ethereumData = coinFactory.mapToCoin(apiService.getCoinInfoById("ethereum").get());
        return List.of(bitcoinData, ethereumData);
    }
}
