package pl.com.bottega.exchangerate.api;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExchangeRateDto {

    private String currency;

    private BigDecimal amount;

    private LocalDate date;

    public ExchangeRateDto(String currency, BigDecimal amount, LocalDate date) {
        this.currency = currency;
        this.amount = amount;
        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
