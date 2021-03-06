package pl.com.bottega.exchangerate.domain.commands;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExchangeRateRequestCommand implements Command{

   // private Long id;
    private LocalDate date;
    private String currency;
    private BigDecimal rate;

//    public ExchangeRateRequestCommand() {
//    }


    public void validate(ValidationErrors errors){
        //validatePresence(errors,"id",id);
        validatePresence(errors,"date", date);
        validatePresence(errors,"currency", currency);
        validatePresence(errors,"rate", rate);
    }


//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
