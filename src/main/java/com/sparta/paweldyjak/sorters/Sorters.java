package com.sparta.paweldyjak.sorters;

/**
 * Sorters interface
 */
public interface Sorters {
    /**
     * Sort array.
     * @param arrayToSort Unsorted Array.
     * @return sorted Array.
     */
    int[] sort(int[] arrayToSort);
    /**
     * Returns Long with sorting time.
     * @return Long with sorting time.
     */
    Long getSortingTime();

    /**
     * Returns sorter name.
     * @return String with sorter name.
     */
    String getSorterName();
}
