package csiem.backend.controller;

import csiem.backend.model.Coin;
import csiem.backend.model.CurrentPrice;
import csiem.backend.model.coingeckoApi.CoinApi;
import csiem.backend.model.coingeckoApi.CurrentPriceApi;
import csiem.backend.model.coingeckoApi.ImageApi;
import csiem.backend.model.coingeckoApi.MarketDataApi;
import csiem.backend.service.coingeckoApi.CoinGeckoApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CoinControllerTest {

    @MockBean
    CoinGeckoApiService apiService;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void testGetStandardCoins() {
        //GIVEN
        CoinApi mockedBitcoin = getMockedCoin("Bitcoin");
        when(apiService.getCoinInfoById("bitcoin")).thenReturn(mockedBitcoin);
        CoinApi mockedEthereum = getMockedCoin("Ethereum");
        when(apiService.getCoinInfoById("ethereum")).thenReturn(mockedEthereum);

        //WHEN
        ResponseEntity<Coin[]> response = restTemplate.getForEntity("/api/coins", Coin[].class);

        //THEN
        Coin[] expected = {
                Coin.builder()
                        .id("bitcoin")
                        .name("Bitcoin")
                        .lastUpdated(LocalDateTime.of(2021,12,12,5,0))
                        .currentPrice(CurrentPrice.builder().eur(1000).usd(1500).build())
                        .imageUrl("testUrl")
                        .build(),
                Coin.builder()
                        .id("ethereum")
                        .name("Ethereum")
                        .lastUpdated(LocalDateTime.of(2021,12,12,5,0))
                        .currentPrice(CurrentPrice.builder().eur(1000).usd(1500).build())
                        .imageUrl("testUrl")
                        .build(),

        };
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(expected));

    }

    private CoinApi getMockedCoin(String coin) {
        return CoinApi.builder()
                .id(coin.toLowerCase())
                .name(coin)
                .image(ImageApi
                        .builder()
                        .imageUrl("testUrl").
                        build())
                .marketData(
                        MarketDataApi.builder().currentPrice(CurrentPriceApi.builder().eur(1000).usd(1500).build())
                                .build())
                .lastUpdated(LocalDateTime.of(2021, 12, 12, 5, 0))
                .build();
    }


}