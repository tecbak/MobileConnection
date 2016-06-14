package ua.rud.mobilecompany.tariff;

/**
 * Filters for {@link Tariff}
 */
public enum TariffFilter implements Filter<Tariff> {
    TYPE {
        @Override
        public boolean apply(Tariff tariff) {
            String className = tariff.getClass().getSimpleName();
            return className.equals(getValue());
        }
    },
    NAME {
        @Override
        public boolean apply(Tariff tariff) {
            String name = tariff.getName();
            return name.equals(getValue());
        }
    },
    MONTH_FEE {
        @Override
        public boolean apply(Tariff tariff) {
            try {
                long value = Long.parseLong(getValue());
                return tariff.getMonthFee() == value;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    },
    MINUTE_FEE {
        @Override
        public boolean apply(Tariff tariff) {
            try {
                long value = Long.parseLong(getValue());
                return tariff.getMinuteFee() == value;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    };

    private String value;

    public abstract boolean apply(Tariff tariff);

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
