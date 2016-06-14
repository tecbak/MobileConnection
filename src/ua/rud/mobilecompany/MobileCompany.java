package ua.rud.mobilecompany;

import ua.rud.mobilecompany.account.Account;
import ua.rud.mobilecompany.account.AccountParser;
import ua.rud.mobilecompany.tariff.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Class operates with tariffs and user accounts
 */
public class MobileCompany {
    private List<Account> accounts = new ArrayList<>();
    private List<Tariff> tariffs = new ArrayList<>();
    private List<Tariff> filteredTariffs = new ArrayList<>();

    /*Constructor*/
    public MobileCompany() {

    }

    /*Getters and setters*/
    public Set<String> getClients() {
        Set<String> clients = new HashSet<>();
        for (Account account : accounts) {
            clients.add(account.getClientName());
        }
        return clients;
    }

    public int countClients() {
        return getClients().size();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Tariff> getTariffs() {
        return tariffs;
    }

    public void addTariff(Tariff tariff) {
        tariffs.add(tariff);
    }

    /*Methods*/

    /**
     * Sorts tariffs using a comparator
     *
     * @param comparator comparator for sorting
     */
    public void sortTariffs(Comparator<Tariff> comparator) {
        Collections.sort(tariffs, comparator);
    }

    /**
     * Sorts tariffs using a list of comparators
     *
     * @param comparators list of comparators
     */
    public void sortTariffs(List<Comparator<Tariff>> comparators) {
        MultiComparator<Tariff> multiComparator = new MultiComparator<>(comparators);
        Collections.sort(tariffs, multiComparator);
    }


    /**
     * Filters tariffs according to list of filters
     *
     * @param filters list of filters
     */
    public void filterTariffs(List<Filter<Tariff>> filters) {
        MultiFilter multiFilter = new MultiFilter(filters);
        filterTariffs(multiFilter);
    }

    /**
     * Filters tariffs according to a multi-filter
     *
     * @param filter multi-filter
     */
    public void filterTariffs(Filter<Tariff> filter) {
        filteredTariffs = new ArrayList<>();
        for (Tariff tariff : tariffs) {
            if (filter.apply(tariff)) {
                filteredTariffs.add(tariff);
            }
        }
    }

    public void printFilteredTariffs() {
        print(filteredTariffs);
    }

    public void printTariffs() {
        print(tariffs);
    }

    private void print(List<Tariff> tariffList) {
        for (Tariff tariff : tariffList) {
            System.out.println(tariff);
        }
    }

    /**
     * Loads list of tariffs from CSV file
     *
     * @param fileName path to file
     * @throws IOException
     */
    public void readTariffsFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        tariffs = readTariffs(reader);
    }

    private List<Tariff> readTariffs(BufferedReader reader) throws IOException {
        List<Tariff> tariffs = new ArrayList<>();

        String line = reader.readLine();
        while (line != null) {
            Tariff tariff = parseTariff(line);
            if (tariff != null) {
                tariffs.add(tariff);
            }
            line = reader.readLine();
        }
        return tariffs;
    }

    private Tariff parseTariff(String line) {
        try {
            String[] tokens = line.toUpperCase().split(";");
            String type = tokens[0];
            TariffParser parser = TariffParser.valueOf(type);
            return parser.parse(tokens);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Loads list of Accounts from CSV file
     *
     * @param fileName path to file
     * @throws IOException
     */
    public void readAccountsFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        accounts = readAccounts(reader);
    }

    private List<Account> readAccounts(BufferedReader reader) throws IOException {
        List<Account> accounts = new ArrayList<>();

        String line = reader.readLine();
        while (line != null) {
            Account account = parseAccount(line);
            if (account != null) {
                accounts.add(account);
            }
            line = reader.readLine();
        }
        return accounts;
    }

    private Account parseAccount(String line) {
        try {
            String[] tokens = line.toUpperCase().split(";");
            String type = tokens[0];
            AccountParser parser = AccountParser.valueOf(type);
            return parser.parse(tokens, tariffs);
        } catch (Exception e) {
            return null;
        }
    }
}