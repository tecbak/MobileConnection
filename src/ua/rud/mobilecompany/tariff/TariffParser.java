package ua.rud.mobilecompany.tariff;

/**
 * Parsers for {@link Tariff}
 */
public enum TariffParser {
    CORPORATE {
        @Override
        public Tariff parse(String[] tokens) {
            try {
                String name = tokens[1];
                long monthFee = Long.parseLong(tokens[2]);
                long minuteFee = Long.parseLong(tokens[3]);
                int freeMinutes = Integer.parseInt(tokens[4]);
                CorporateTariff tariff = new CorporateTariff("CORPORATE") {{
                    setName(name);
                    setMonthFee(monthFee);
                    setMinuteFee(minuteFee);
                    setFreeMinutes(freeMinutes);
                }};
                return tariff;
            } catch (Exception e) {
                return null;
            }
        }
    },
    INDIVIDUAL {
        @Override
        public Tariff parse(String[] tokens) {
            try {
                String name = tokens[1];
                long monthFee = Long.parseLong(tokens[2]);
                long minuteFee = Long.parseLong(tokens[3]);
                IndividualTariff tariff = new IndividualTariff("INDIVIDUAL") {{
                    setName(name);
                    setMonthFee(monthFee);
                    setMinuteFee(minuteFee);
                }};
                return tariff;
            } catch (Exception e) {
                return null;
            }
        }
    },
    CONTRACT {
        @Override
        public Tariff parse(String[] tokens) {
            try {
                String name = tokens[1];
                long monthFee = Long.parseLong(tokens[2]);
                long minuteFee = Long.parseLong(tokens[3]);
                double discountRate = Double.parseDouble(tokens[4]);
                ContractTariff tariff = new ContractTariff("CONTRACT") {{
                    setName(name);
                    setMonthFee(monthFee);
                    setMinuteFee(minuteFee);
                    setDiscountRate(discountRate);
                }};
                return tariff;
            } catch (Exception e) {
                return null;
            }
        }
    };

    public abstract Tariff parse(String[] tokens);
}
