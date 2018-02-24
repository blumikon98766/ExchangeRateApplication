package pl.com.bottega.exchangerate.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.exchangerate.domain.commands.Command;
import pl.com.bottega.exchangerate.domain.commands.ExchangeCurrencyCommand;
import pl.com.bottega.exchangerate.infrastructure.JPACurrencyFinder;

import java.util.List;

@Component
public class ExchangeCurrencyHandler implements Handler<ExchangeCurrencyCommand, ChangedCurrencyDto>{

    private CurrencyFinder currencyFinder;
//    private JPACurrencyFinder currencyFinder;

    public ExchangeCurrencyHandler(CurrencyFinder currencyFinder) {
        this.currencyFinder = currencyFinder;
    }

    @Transactional
    public ChangedCurrencyDto handle(ExchangeCurrencyCommand command) {
        ChangedCurrencyDto cos = new ChangedCurrencyDto();
        if(command.getCurrencyFrom().equals("PLN")) {
             cos = checkMainCurrency(command);
        }

        return cos;
    }

    private ChangedCurrencyDto checkMainCurrency(ExchangeCurrencyCommand command) {
        ChangedCurrencyDto changedCurrencyDto = new ChangedCurrencyDto();
        if(command.getCurrencyFrom().equals("PLN")){

            ExchangeRateDto exchangeRateDto = new ExchangeRateDto(command.getCurrencyTo(),command.getAmound(),command.getDate());
            List<ExchangeRateDto> result = currencyFinder.getCurrency(exchangeRateDto);

            if(result.isEmpty()) {

            }
            else {
            ExchangeRateDto variableExchangeRate = result.get(0);
                changedCurrencyDto.setAmount(command.getAmound());
                changedCurrencyDto.setCurrencyFrom(command.getCurrencyFrom());
                changedCurrencyDto.setCurrencyTo(command.getCurrencyTo());
                changedCurrencyDto.setDate(command.getDate());
                changedCurrencyDto.setCalculatedAmound(variableExchangeRate.getAmount().divide(command.getAmound()));
            }
        }
        return changedCurrencyDto;

    }

    @Override
    public Class<? extends Command> getSupportedCommandClass() {
        return null;
    }
}
