package csiem.backend.service;

import csiem.backend.model.Coin;
import csiem.backend.model.CurrentPrice;
import csiem.backend.model.coingeckoApi.CoinApi;
import csiem.backend.model.coingeckoApi.CurrentPriceApi;
import csiem.backend.model.coingeckoApi.ImageApi;
import csiem.backend.model.coingeckoApi.MarketDataApi;
import csiem.backend.service.coingeckoApi.CoinGeckoApiService;

import csiem.backend.service.factory.CoinFactory;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

class CoinServiceTest {

    @Test
    void testGetCoinDataById() {

        //GIVEN
        Optional<CoinApi> testCoinApi = getMockedCoinApi();
        Optional<Coin> testCoin = getMockedCoin();
        CoinGeckoApiService apiService = mock(CoinGeckoApiService.class);
        when(apiService.getCoinInfoById("testcoin")).thenReturn(testCoinApi);
        CoinFactory coinFactory = mock(CoinFactory.class);
        when(coinFactory.mapToCoin(testCoinApi.get())).thenReturn(testCoin.get());
        CoinService coinService = new CoinService(apiService, coinFactory);

        //WHEN
        Coin actual = coinService.getCoinDataById("testcoin");

        //THEN
        assertThat(actual, is(testCoin.get()));
        verify(apiService).getCoinInfoById("testcoin");
        verify(coinFactory).mapToCoin(testCoinApi.get());

    }

    @Test
    void testGetStandardCoins() {

        //GIVEN
        Optional<CoinApi> testCoinApi = getMockedCoinApi();
        Optional<Coin> testCoin = getMockedCoin();
        CoinGeckoApiService apiService = mock(CoinGeckoApiService.class);
        when(apiService.getCoinInfoById("bitcoin")).thenReturn(testCoinApi);
        when(apiService.getCoinInfoById("ethereum")).thenReturn(testCoinApi);
        CoinFactory coinFactory = mock(CoinFactory.class);
        when(coinFactory.mapToCoin(testCoinApi.get())).thenReturn(testCoin.get());
        CoinService coinService = new CoinService(apiService, coinFactory);

        //WHEN
        List<Coin> actual = coinService.getStandardCoins();

        //THEN
        assertThat(actual, is(List.of(testCoin.get(), testCoin.get())));
        verify(apiService).getCoinInfoById("bitcoin");
        verify(apiService).getCoinInfoById("ethereum");
        verify(coinFactory, times(2)).mapToCoin(testCoinApi.get());

    }

    private Optional<CoinApi> getMockedCoinApi() {
        return Optional.of(CoinApi.builder()
                .id("testcoin")
                .name("Testcoin")
                .image(ImageApi
                        .builder()
                        .imageUrl("testUrl").
                        build())
                .marketData(
                        MarketDataApi.builder().currentPrice(CurrentPriceApi.builder().eur(1000).usd(1500).build())
                                .build())
                .lastUpdated(LocalDateTime.of(2021, 12, 12, 5, 0))
                .build());
    }

    private Optional<Coin> getMockedCoin() {
        return Optional.of(Coin.builder()
                .id("testcoin")
                .name("Testcoin")
                .imageUrl("testUrl")
                .currentPrice(CurrentPrice.builder().eur(1000).usd(1000).build())
                .lastUpdated(LocalDateTime.of(2021, 12, 12, 5, 0))
                .build());
    }

}