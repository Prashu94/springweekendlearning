package rewards;

import io.spring.learning.common.money.Percentage;
import io.spring.learning.entity.Account;
import io.spring.learning.repository.AccountRepository;

import java.util.HashMap;
import java.util.Map;

public class StubAccountRepository implements AccountRepository {
    private Map<String, Account> accountsByCreditCard = new HashMap<String, Account>();

    public StubAccountRepository() {
        Account account = new Account("123456789", "Keith and Keri Donald");
        account.addBeneficiary("Annabelle", Percentage.valueOf("50%"));
        account.addBeneficiary("Corgan", Percentage.valueOf("50%"));
        accountsByCreditCard.put("1234123412341234", account);
    }

    @Override
    public String getInfo() {
        return "TEST";
    }

    public Account findByCreditCard(String creditCardNumber) {
        Account account = accountsByCreditCard.get(creditCardNumber);
        if (account == null) {
            throw new RuntimeException("no account has been found for credit card number " + creditCardNumber);
        }
        return account;
    }

    public void updateBeneficiaries(Account account) {
        // nothing to do, everything is in memory
    }
}
