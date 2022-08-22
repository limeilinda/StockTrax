package com.passion.stocktrax.stock;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TickerRepository extends CrudRepository<Ticker, String> {

    Iterable<Ticker> findByStocknameContaining(String name);

    Iterable<Ticker> findBySymbolContaining(String symbol);

}
