package csiem.backend.service;

import csiem.backend.model.Coin;
import csiem.backend.model.coingeckoApi.CoinApi;
import csiem.backend.service.coingeckoApi.CoinGeckoApiService;
import csiem.backend.service.factory.CoinFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinService {
    private final CoinGeckoApiService apiService;
    private final CoinFactory coinFactory;

    @Autowired
    public CoinService(CoinGeckoApiService apiService, CoinFactory coinFactory) {
        this.apiService = apiService;
        this.coinFactory = coinFactory;
    }

    public Coin getCoinData(String coinId) {
        CoinApi coinApi = apiService.getCoinInfo(coinId);
        return coinFactory.mapToCoin(coinApi);

    }

    public List<Coin> getStandardCoins() {
        Coin bitcoinData = coinFactory.mapToCoin(apiService.getCoinInfo("bitcoin"));
        Coin ethereumData = coinFactory.mapToCoin(apiService.getCoinInfo("ethereum"));
        return List.of(bitcoinData, ethereumData);
    }
}
