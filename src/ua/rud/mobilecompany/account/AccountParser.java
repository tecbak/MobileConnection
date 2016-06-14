package ua.rud.mobilecompany.account;

import ua.rud.mobilecompany.account.Account;
import ua.rud.mobilecompany.account.CorporateAccount;
import ua.rud.mobilecompany.account.IndividualAccount;
import ua.rud.mobilecompany.tariff.CorporateTariff;
import ua.rud.mobilecompany.tariff.IndividualTariff;
import ua.rud.mobilecompany.tariff.Tariff;

import java.util.ArrayList;
import java.util.List;

/**
 * Parsers for {@link Account}
 */
public enum AccountParser {
    CORPORATE {
        @Override
        public Account parse(String[] tokens, List<Tariff> tariffs) {
            try {
                String clientName = tokens[1];
                long balance = Long.parseLong(tokens[2]);

                Tariff tariff = findTariff(tokens[3], tariffs);

                if (tariff == null || !(tariff instanceof CorporateTariff)) {
                    return null;
                }

                List<Long> numbers = new ArrayList<>();
                for (String token : tokens[4].split("/")) {
                    numbers.add(Long.parseLong(token));
                }

                CorporateAccount account = new CorporateAccount() {{
                    setClientName(clientName);
                    setBalance(balance);
                    setTariff((CorporateTariff) tariff);
                    addNumbers(numbers);
                }};

                return account;
            } catch (Exception e) {
                return null;
            }
        }
    },
    INDIVIDUAL {
        @Override
        public Account parse(String[] tokens, List<Tariff> tariffs) {
            try {

                String clientName = tokens[1];
                long balance = Long.parseLong(tokens[2]);

                Tariff tariff = findTariff(tokens[3], tariffs);

                if (tariff == null || !(tariff instanceof IndividualTariff)) {
                    return null;
                }

                long number = Long.parseLong(tokens[4]);

                IndividualAccount account = new IndividualAccount() {{
                    setClientName(clientName);
                    setBalance(balance);
                    setIndividualTariff((IndividualTariff) tariff);
                    setNumber(number);
                }};

                return account;
            } catch (Exception e) {
                return null;
            }
        }
    };

    private static Tariff findTariff(String name, List<Tariff> tariffs) {
        for (Tariff tariff : tariffs) {
            if (tariff.getName().equals(name)) {
                return tariff;
            }
        }
        return null;
    }

    public abstract Account parse(String[] tokens, List<Tariff> tariffs);

}
