package com.passion.stocktrax.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/ticker") // This means URL's start with /accounts (after Application path)
public class TickerController {
    @Autowired
    private TickerRepository tickerRepository;

//    @PostMapping(path="/add") // Map ONLY POST Requests
//    public @ResponseBody String addNewTicker (@RequestParam String symbol
//            , @RequestParam String stockName) {
//        // @ResponseBody means the returned String is the response, not a view name
//        // @RequestParam means it is a parameter from the GET or POST request
//
//        Ticker n = new Ticker();
//        n.setStockname(stockName);
//        n.setSymbol(symbol);
//        tickerRepository.save(n);
//        return "Saved";
//    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Ticker> getAllTickers() {
        //     This returns a JSON or XML with the users
        return tickerRepository.findAll();
    }

    @GetMapping(path="/find/{ticker}")
    public @ResponseBody Optional<Ticker> getTicker(@PathVariable String ticker) {
        return tickerRepository.findById(ticker);
    }

    @GetMapping(path="/search/name/{name}")
    public @ResponseBody Iterable<Ticker> getAllTickersContainingName(@PathVariable String name) {
        return tickerRepository.findByStocknameContaining(name);
    }

    @GetMapping(path="/search/symbol/{ticker}")
    public @ResponseBody Iterable<Ticker> getAllTickersContainingTicker(@PathVariable String ticker) {
        return tickerRepository.findBySymbolContaining(ticker);
    }
}
