package csiem.backend.service.coingeckoApi;

import csiem.backend.model.coingeckoApi.CoinApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.Optional;

@Service
public class CoinGeckoApiService {

    private final WebClient webClient;

    @Autowired
    public CoinGeckoApiService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Optional<CoinApi> getCoinInfoById(String coinId) {
        CoinApi response = webClient
                .get()
                .uri("/coins/" + coinId)
                .retrieve()
                .bodyToMono(CoinApi.class)
                .block(Duration.ofSeconds(10));

        if (response == null) {
            return Optional.empty();
        }

        return Optional.of(response);
    }


}
