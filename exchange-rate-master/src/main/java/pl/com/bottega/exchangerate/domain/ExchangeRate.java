package pl.com.bottega.exchangerate.domain;

import pl.com.bottega.exchangerate.domain.commands.Command;
import pl.com.bottega.exchangerate.domain.commands.ExchangeRateRequestCommand;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class ExchangeRate {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private LocalDate localDate;

    @Column
    private String currency;

    @Column
    BigDecimal rate;

    public ExchangeRate(ExchangeRateRequestCommand command) {
        this.localDate = command.getDate();
        this.currency = command.getCurrency();
        this.rate = command.getRate();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
