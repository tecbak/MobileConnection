package ua.rud.mobilecompany;

import ua.rud.mobilecompany.tariff.Filter;
import ua.rud.mobilecompany.tariff.Tariff;
import ua.rud.mobilecompany.tariff.TariffCriterion;
import ua.rud.mobilecompany.tariff.TariffFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws IOException {
        MobileCompany company = new MobileCompany();

        //Создать список тарифов компании.
        company.readTariffsFromFile("tariffs.csv");
        company.readAccountsFromFile("accounts.csv");

        //Посчитать общую численность клиентов.
        int clientsNumber = company.countClients();

        //Провести сортировку тарифов на основе размера абонентской платы.
        company.sortTariffs(TariffCriterion.MONTH_FEE);


        //Найти тариф в компании, соответствующий заданному диапазону параметров.
        TariffFilter.MINUTE_FEE.setValue("100");
        TariffFilter.MONTH_FEE.setValue("1000");
        List<Filter<Tariff>> filters = Arrays.asList(TariffFilter.MINUTE_FEE, TariffFilter.MONTH_FEE);
        company.filterTariffs(filters);


        //Output
        System.out.println("Number of clients = " + clientsNumber);
        System.out.println();

        System.out.println("Tariffs sorted by month fee:");
        company.printTariffs();
        System.out.println();

        System.out.println("Result of search:");
        company.printFilteredTariffs();
    }
}
