package pl.com.bottega.exchangerate.api;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.commands.Command;
import pl.com.bottega.exchangerate.domain.commands.ExchangeRateRequestCommand;
import pl.com.bottega.exchangerate.infrastructure.JPAExchangeCurrencyRepository;

@Component
public class ExchangeRateHandler implements Handler<ExchangeRateRequestCommand, Void>{

    private JPAExchangeCurrencyRepository jpaExchangeCurrencyRepository;

    public ExchangeRateHandler(JPAExchangeCurrencyRepository jpaExchangeCurrencyRepository) {
        this.jpaExchangeCurrencyRepository = jpaExchangeCurrencyRepository;
    }

    @Transactional
    public Void handle(ExchangeRateRequestCommand command) {
        ExchangeRate exchangeRate = new ExchangeRate(command);
        jpaExchangeCurrencyRepository.save(exchangeRate);
        return null;
    }

    @Override
    public Class<? extends Command> getSupportedCommandClass() {
        return null;
    }
}
