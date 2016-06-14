package ua.rud.mobilecompany.account;

import ua.rud.mobilecompany.tariff.IndividualTariff;

public class IndividualAccount extends Account {
    private IndividualTariff individualTariff;
    private long number;

    /*Getters and setters*/
    @Override
    public IndividualTariff getTariff() {
        return individualTariff;
    }

    public void setIndividualTariff(IndividualTariff individualTariff) {
        this.individualTariff = individualTariff;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
