package pl.com.bottega.exchangerate.api;

import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.LocalDate;
import pl.com.bottega.exchangerate.domain.commands.Command;
import pl.com.bottega.exchangerate.domain.commands.ExchangeRateRequestCommand;

import java.math.BigDecimal;
import java.util.List;

public interface CurrencyFinder {

    List<ExchangeRateDto> getCurrency(ExchangeRateDto exchangeRateDto);

    List<ExchangeRate> checkPutCurrency(ExchangeRateRequestCommand command);
}
