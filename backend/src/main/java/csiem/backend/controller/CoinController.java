package csiem.backend.controller;

import csiem.backend.model.Coin;
import csiem.backend.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/coins")
public class CoinController {

    private final CoinService coinService;

    @Autowired
    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping
    public List<Coin> getStandardCoins(){
        return coinService.getStandardCoins();
    }

    @GetMapping("{coinId}")
    public Coin getBitcoinPrice(@PathVariable String coinId){
        return coinService.getCoinData(coinId);
    }
}
