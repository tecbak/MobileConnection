package ua.rud.mobilecompany.tariff;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Compare objects by several criteria
 *
 * @param <T> type of objects
 */
public class MultiComparator<T> implements Comparator<T> {
    private List<Comparator<T>> comparators = new ArrayList<>();

    public MultiComparator(List<Comparator<T>> comparators) {
        this.comparators = comparators;
    }

    /**
     * Apply comparison
     *
     * @param o1    first object to compare
     * @param o2    second object to compare
     * @return  0 if the objects are equal, 1 if the first object is greater then the second one,
     *          -1 if the first object is less then the second one
     */
    @Override
    public int compare(T o1, T o2) {
        for (Comparator<T> comparator : comparators) {
            int comparison = comparator.compare(o1, o2);
            if (comparison != 0) {
                return comparison;
            }
        }
        return 0;
    }
}
