package pl.com.bottega.exchangerate.infrastructure;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.com.bottega.exchangerate.api.ChangedCurrencyDto;
import pl.com.bottega.exchangerate.api.ExchangeRateDto;
import pl.com.bottega.exchangerate.api.CurrencyFinder;
import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.LocalDate;
import pl.com.bottega.exchangerate.domain.commands.Command;
import pl.com.bottega.exchangerate.domain.commands.ExchangeCurrencyCommand;
import pl.com.bottega.exchangerate.domain.commands.ExchangeRateRequestCommand;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

@Component
public class JPACurrencyFinder implements CurrencyFinder{

    @PersistenceContext
    private EntityManager entityManager;

    public JPACurrencyFinder() {
    }

    public JPACurrencyFinder(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ExchangeRateDto> getCurrency(ExchangeRateDto exchangeRateDto) {
        List<ExchangeRateDto> result = entityManager.createQuery("FROM exchange_rate e WHERE e.currency = :currency AND " +
                "e.localDate = :date", ExchangeRateDto.class)
                .setParameter("currency", exchangeRateDto.getCurrency())
                .setParameter("date", exchangeRateDto.getDate())
                .getResultList();
        return result;
    }

    @Override
    public List<ExchangeRate> checkPutCurrency(ExchangeRateRequestCommand command){
        List<ExchangeRate> result = entityManager.createQuery("FROM exchange_rate e WHERE e.currency = :currency AND " +
                "e.localDate = :date", ExchangeRate.class)
                .setParameter("currency", command.getCurrency())
                .setParameter("date", command.getDate())
                .getResultList();
        return result;
    }


//    @Override
//    public List<ExchangeRateDto> getCurrency(LocalDate date, String currency, BigDecimal rate) {
//
//        List<ExchangeRateDto> result = entityManager.createQuery("SELECT e" +
//                " FROM exchange_rate e WHERE e.local_date = :date AND e.currency = :currency").
//                setParameter("currency", currency ).
//                setParameter("local_date",date).
//                setParameter("rate", rate).getResultList();
//    return result;
//    }
}
