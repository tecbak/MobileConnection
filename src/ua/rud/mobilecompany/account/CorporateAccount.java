package ua.rud.mobilecompany.account;

import ua.rud.mobilecompany.tariff.CorporateTariff;
import ua.rud.mobilecompany.tariff.Tariff;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CorporateAccount extends Account {
    private CorporateTariff corporateTariff;
    private Set<Long> numbers = new HashSet<>();

    /*Getters and setters*/
    @Override
    public Tariff getTariff() {
        return corporateTariff;
    }

    public void setTariff(CorporateTariff corporateTariff) {
        this.corporateTariff = corporateTariff;
    }

    public void addNumber(long number) {
        numbers.add(number);
    }

    public void addNumbers(List<Long> numbers) {
        for (Long number : numbers) {
            this.numbers.add(number);
        }
    }

    public boolean removeNumber(long number) {
        return numbers.remove(number);
    }


}

