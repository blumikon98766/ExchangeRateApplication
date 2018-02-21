package pl.com.bottega.exchangerate.ui.rest;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.exchangerate.api.CommandGateway;
import pl.com.bottega.exchangerate.domain.commands.ExchangeRateRequestCommand;

@RestController
public class CurrencyExchangeController {

    private CommandGateway command;

    @PutMapping("/exchange-rate")
    public void addExchangeRate(@RequestBody ExchangeRateRequestCommand request){
        command.execute(request);
    }

}
