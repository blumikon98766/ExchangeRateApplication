package pl.com.bottega.exchangerate.api;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.commands.Command;
import pl.com.bottega.exchangerate.domain.commands.ExchangeRateRequestCommand;
import pl.com.bottega.exchangerate.infrastructure.JPACurrencyFinder;
import pl.com.bottega.exchangerate.infrastructure.JPAExchangeCurrencyRepository;

import java.util.List;

@Component
public class ExchangeRateHandler implements Handler<ExchangeRateRequestCommand, Void>{

    private JPAExchangeCurrencyRepository jpaExchangeCurrencyRepository;
    private JPACurrencyFinder jpaCurrencyFinder;

    public ExchangeRateHandler(JPAExchangeCurrencyRepository jpaExchangeCurrencyRepository, JPACurrencyFinder jpaCurrencyFinder) {
        this.jpaExchangeCurrencyRepository = jpaExchangeCurrencyRepository;
        this.jpaCurrencyFinder = jpaCurrencyFinder;
    }

    @Transactional
    public Void handle(ExchangeRateRequestCommand command) {
        ExchangeRate exchangeRate = new ExchangeRate(command);
        checkCurrency(command, exchangeRate);
//        jpaExchangeCurrencyRepository.save(exchangeRate);
        return null;
    }

    private void checkCurrency(ExchangeRateRequestCommand command, ExchangeRate exchangeRate){

        List<ExchangeRate> listExchangeRate = jpaCurrencyFinder.checkPutCurrency(command);

        if (listExchangeRate.isEmpty()){
            jpaExchangeCurrencyRepository.save(exchangeRate);
        }

        else {
            for (ExchangeRate l : listExchangeRate) {
                if (l.getCurrency().equals(command.getCurrency()))
                    jpaExchangeCurrencyRepository.update(command);
                else
                    jpaExchangeCurrencyRepository.save(exchangeRate);

            }
        }

    }

    @Override
    public Class<? extends Command> getSupportedCommandClass() {
        return ExchangeRateRequestCommand.class;
    }
}
