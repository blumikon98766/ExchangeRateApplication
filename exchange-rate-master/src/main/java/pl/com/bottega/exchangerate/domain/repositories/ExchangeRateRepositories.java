package pl.com.bottega.exchangerate.domain.repositories;

import pl.com.bottega.exchangerate.domain.ExchangeRate;

public interface ExchangeRateRepositories {
    void save(ExchangeRate exchangeRate);
    ExchangeRate get(Long exchangeRateId);

}
