package ua.rud.mobilecompany.tariff;

import java.util.Comparator;

/**
 * Comparators for {@link Tariff}
 */
public enum TariffCriterion implements Comparator<Tariff> {
    TYPE {
        @Override
        public int compare(Tariff o1, Tariff o2) {
            String type1 = o1.getClass().getSimpleName();
            String type2 = o2.getClass().getSimpleName();
            return type1.compareTo(type2);
        }
    },

    NAME {
        @Override
        public int compare(Tariff o1, Tariff o2) {
            String name1 = o1.getName();
            String name2 = o2.getName();
            return name1.compareTo(name2);
        }
    },

    MONTH_FEE {
        @Override
        public int compare(Tariff o1, Tariff o2) {
            long monthFee1 = o1.getMonthFee();
            long monthFee2 = o2.getMonthFee();
            return Long.compare(monthFee1, monthFee2);
        }
    },

    MINUTE_FEE {
        @Override
        public int compare(Tariff o1, Tariff o2) {
            long minuteFee1 = o1.getMinuteFee();
            long minuteFee2 = o2.getMinuteFee();
            return Long.compare(minuteFee1, minuteFee2);
        }
    },

    ID {
        @Override
        public int compare(Tariff o1, Tariff o2) {
            int id1 = o1.getId();
            int id2 = o2.getId();
            return Integer.compare(id1, id2);
        }
    }
}
