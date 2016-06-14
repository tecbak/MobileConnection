package ua.rud.mobilecompany.tariff;

/**
 * IndividualTariff is a class for cell phone tariffs designed for
 * individual customers.
 *
 * @see Tariff
 */
public class IndividualTariff extends Tariff {
    /*Constructor*/
    public IndividualTariff(String type) {
        super(type);
    }

    /*Methods*/
    /**
     * Calculates and returns the cost of the call.
     * <p>
     * Multiplies the cost per minute by the duration of call in minutes.
     *
     * @param minutes the duration of call in minutes
     * @return the cost of the call
     */
    @Override
    public long getCallFee(int minutes) {
        return super.getMinuteFee() * minutes;
    }
}
