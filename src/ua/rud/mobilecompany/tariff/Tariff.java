package ua.rud.mobilecompany.tariff;

public abstract class Tariff {
    private static int idCounter = 0;

    private final int id;
    private final String type;
    private String name;
    private long monthFee;
    private long minuteFee;

    /*Constructor*/
    public Tariff(String type) {
        this.id = idCounter++;
        this.type = type;
    }

    /*Getters and setters*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMinuteFee() {
        return minuteFee;
    }

    public void setMinuteFee(long minuteFee) {
        this.minuteFee = minuteFee;
    }

    public long getMonthFee() {
        return monthFee;
    }

    public void setMonthFee(long monthFee) {
        this.monthFee = monthFee;
    }

    public int getId() {
        return id;
    }

    /*Methods*/

    /**
     * Returns the cost of the call according to its duration in minutes.
     *
     * @param minutes the duration of call in minutes
     * @return the cost of the call
     */
    public abstract long getCallFee(int minutes);

    @Override
    public String toString() {
        String s;
        s = String.format("%-6s", "id=" + id);
        s += String.format("%-15s", type);
        s += String.format("%-20s", "name=" + name);
        s += String.format("%-20s", "monthFee=" + monthFee);
        s += String.format("%-20s", "minuteFee=" + minuteFee);
        return s;
    }
}
