package pl.com.bottega.exchangerate.domain;

import pl.com.bottega.exchangerate.domain.commands.Command;
import pl.com.bottega.exchangerate.domain.commands.ExchangeRateRequestCommand;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "exchange_rate")
public class ExchangeRate {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "local_date")
    private LocalDate localDate;

    @Column
    private String currency;

    @Column(precision = 10, scale = 6)
    private BigDecimal rate;

    public ExchangeRate(ExchangeRateRequestCommand command) {
//        this.id = command.getId();
        this.localDate = command.getDate();
        this.currency = command.getCurrency();
        this.rate = command.getRate();
    }

    public ExchangeRate() {
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
