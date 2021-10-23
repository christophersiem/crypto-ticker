package csiem.backend.service.coingeckoApi;

import csiem.backend.model.coingeckoApi.CoinApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class CoinGeckoApiService {

    private final WebClient webClient;

    @Autowired
    public CoinGeckoApiService(WebClient webClient) {
        this.webClient = webClient;
    }

    public CoinApi getCoinInfoById(String coinId) {

        return webClient
                .get()
                .uri("/coins/" + coinId)
                .retrieve()
                .bodyToMono(CoinApi.class)
                .block(Duration.ofSeconds(10));
    }
}
