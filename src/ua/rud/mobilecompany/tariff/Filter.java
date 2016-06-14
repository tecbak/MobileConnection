package ua.rud.mobilecompany.tariff;

public interface Filter<T> {
    boolean apply(T object);
}
