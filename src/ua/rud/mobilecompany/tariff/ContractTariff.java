package ua.rud.mobilecompany.tariff;

/**
 * IndividualTariff is a class for cell phone tariffs designed for
 * individual customers served on contract basis.
 *
 * @see Tariff
 * @see IndividualTariff
 */
public class ContractTariff extends IndividualTariff {
    private double discountRate;

    /*Constructor*/
    public ContractTariff(String type) {
        super(type);
    }

    /*Getters and setters*/
    public double getDiscountRate() {
        return discountRate;
    }

    public ContractTariff setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
        return this;
    }

    /*Methods*/

    /**
     * Calculates and returns the cost of the call.
     * <p>
     * The cost of each following minute decreases for the value of discount rate.
     *
     * @param minutes the duration of call in minutes
     * @return the cost of the call
     */
    @Override
    public long getCallFee(int minutes) {
        long minuteFee = super.getMinuteFee();
        long sum = 0;
        for (int i = 0; i < minutes; i++) {
            sum += minuteFee * Math.pow(1 - discountRate, i);
        }
        return sum;
    }

    @Override
    public String toString() {
        String s = super.toString();
        s += String.format("%-20s", "discountRate=" + discountRate);
        return s;
    }
}
