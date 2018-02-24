package pl.com.bottega.exchangerate.ui.rest;

import org.springframework.web.bind.annotation.*;
import pl.com.bottega.exchangerate.api.ChangedCurrencyDto;
import pl.com.bottega.exchangerate.api.CommandGateway;
import pl.com.bottega.exchangerate.domain.commands.ExchangeCurrencyCommand;
import pl.com.bottega.exchangerate.domain.commands.ExchangeRateRequestCommand;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
public class CurrencyExchangeController {

    private CommandGateway gateway;

    public CurrencyExchangeController(CommandGateway command) {
        this.gateway = command;
    }

    @PutMapping("/exchange-rate")
    public void addExchangeRate(@RequestBody ExchangeRateRequestCommand request) {
        gateway.execute(request);
    }

// @GetMapping("/calculation/{command.date}/{command.currencyFrom}/{command.currencyTo}/{command.amound}")
    //     public ChangedCurrencyDto exchangeCurrencyFromTo(@RequestParam ExchangeCurrencyCommand command){


//    @GetMapping("/calculation?")
//    public ChangedCurrencyDto exchangeCurrencyFromTo(@RequestParam LocalDate date, @PathVariable String currencyFrom,
//                                                     @PathVariable String currencyTo, @PathVariable BigDecimal amound){
//
//    return null;
//    }


   // public ChangedCurrencyDto exchangeCurrencyFromTo(@RequestParam ExchangeCurrencyCommand command) {

////     public ChangedCurrencyDto exchangeCurrencyFromTo(@RequestParam("command") ExchangeCurrencyCommand command) {
//
//
//    @RequestParam String from,
//    @RequestParam String to,
//    @RequestParam BigDecimal amount) {
//
//        ExchangeCurrencyCommand command = new ExchangeCurrencyCommand();
//        command.setDate(date);
//        command.setCurrencyFrom(from);
//        command.setAmound(amount);
//        command.setCurrencyTo(to);

    @GetMapping("/calculation")
     public ChangedCurrencyDto exchangeCurrencyFromTo(@RequestParam String date,
                                                      @RequestParam String from,
                                                      @RequestParam String to,
                                                      @RequestParam BigDecimal amount) {
        ExchangeCurrencyCommand command = new ExchangeCurrencyCommand();
        command.setDate(date);
        command.setCurrencyFrom(from);
        command.setAmound(amount);
        command.setCurrencyTo(to);
        return gateway.execute(command);
    }


}
