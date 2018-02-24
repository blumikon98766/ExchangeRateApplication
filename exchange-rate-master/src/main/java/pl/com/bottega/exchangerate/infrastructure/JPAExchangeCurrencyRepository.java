package pl.com.bottega.exchangerate.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.commands.ExchangeRateRequestCommand;
import pl.com.bottega.exchangerate.domain.repositories.ExchangeRateRepositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class JPAExchangeCurrencyRepository implements ExchangeRateRepositories {


    @PersistenceContext
    private EntityManager entityManager;

    public JPAExchangeCurrencyRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(ExchangeRate exchangeRate) {
        entityManager.merge(exchangeRate);
    }

    public void update(ExchangeRateRequestCommand command) {
        entityManager.createQuery("UPDATE exchange_rate e SET e.rate = :rate WHERE e.currency = :currency AND " +
                "e.localDate = :localDate")
                .setParameter("currency", command.getCurrency())
                .setParameter("localDate", command.getDate())
                .setParameter("rate", command.getRate()).executeUpdate();
    }

    @Override
    public ExchangeRate get(Long exchangeRateId) {
        ExchangeRate exchangeRate = entityManager.find(ExchangeRate.class, exchangeRateId);
        if (exchangeRate == null) {
            throw new NoSuchEntityException();
        }
        return exchangeRate;
    }


}
