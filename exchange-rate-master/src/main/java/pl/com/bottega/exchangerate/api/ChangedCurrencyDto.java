package pl.com.bottega.exchangerate.api;


import pl.com.bottega.exchangerate.domain.commands.ExchangeRateRequestCommand;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ChangedCurrencyDto {

    private String currencyFrom;

    private String currencyTo;

    private BigDecimal amount;

    private BigDecimal calculatedAmound;

    private LocalDate date;

//    public ChangedCurrencyDto(ExchangeRateRequestCommand command) {
//        this.currencyFrom = command.get;
//        this.currencyTo = currencyTo;
//        this.amount = amount;
//        this.calculatedAmound = calculatedAmound;
//        this.date = date;
//    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCalculatedAmound() {
        return calculatedAmound;
    }

    public void setCalculatedAmound(BigDecimal calculatedAmound) {
        this.calculatedAmound = calculatedAmound;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
