package ua.rud.mobilecompany.tariff;

/**
 * CorporateTariff is a class for cell phone tariffs designed for
 * corporate customers.
 *
 * @see Tariff
 */
public class CorporateTariff extends Tariff {
    private int freeMinutes;

    /*Constructor*/
    public CorporateTariff(String type) {
        super(type);
    }

    /*Getters and setters*/
    public int getFreeMinutes() {
        return freeMinutes;
    }

    public void setFreeMinutes(int freeMinutes) {
        this.freeMinutes = freeMinutes;
    }

    /*Methods*/

    /**
     * Calculates and returns the cost of the call.
     * <p>
     * If call duration is less then or equals to the quantity of free minutes
     * the method returns 0, otherwise it returns the cost of minutes exceeding
     * the number of free ones.
     *
     * @param minutes the duration of call in minutes
     * @return the cost of the call
     */
    @Override
    public long getCallFee(int minutes) {
        if (freeMinutes < minutes) {
            return (minutes - freeMinutes) * super.getMinuteFee();
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        String s = super.toString();
        s += String.format("%-20s", "freeMinutes=" + freeMinutes);
        return s;
    }
}
