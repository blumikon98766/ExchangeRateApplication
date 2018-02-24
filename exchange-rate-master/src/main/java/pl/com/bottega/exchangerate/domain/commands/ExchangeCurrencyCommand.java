package pl.com.bottega.exchangerate.domain.commands;

import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExchangeCurrencyCommand implements Command{

    private LocalDate date;
    private String from;
    private String to;
    private BigDecimal amount;

    public void validate(ValidationErrors errors){
        //validatePresence(errors,"id",id);
        validatePresence(errors,"date", date);
        validatePresence(errors,"currencyFrom", from);
        validatePresence(errors,"currencyTo", to);
        validatePresence(errors,"amound", amount);
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = LocalDate.parse(date);
    }

    public String getCurrencyFrom() {
        return from;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.from = currencyFrom;
    }

    public String getCurrencyTo() {
        return to;
    }

    public void setCurrencyTo(String currencyTo) {
        this.to = currencyTo;
    }

    public BigDecimal getAmound() {
        return amount;
    }

    public void setAmound(BigDecimal amound) {
        this.amount = amound;
    }
}
