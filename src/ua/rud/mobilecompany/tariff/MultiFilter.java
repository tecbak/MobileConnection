package ua.rud.mobilecompany.tariff;

import java.util.ArrayList;
import java.util.List;

public class MultiFilter implements Filter<Tariff> {
    private List<Filter<Tariff>> filters = new ArrayList<>();

    public MultiFilter(List<Filter<Tariff>> filters) {
        this.filters = filters;
    }

    public boolean apply(Tariff tariff) {
        for (Filter<Tariff> filter : filters) {
            if (!filter.apply(tariff)) {
                return false;
            }
        }
        return true;
    }
}
