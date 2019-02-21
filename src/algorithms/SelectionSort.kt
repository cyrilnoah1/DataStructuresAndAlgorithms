package algorithms

import kotlin.system.measureTimeMillis

/**
 * Selection Sort implementation.
 * DETAILS: [https://www.geeksforgeeks.org/selection-sort/]
 */
class SelectionSort<T : Comparable<T>> : Sort<T> {

    override fun sort(values: Array<T>): Array<T> {

        // If the list is empty, returning back the same list object.
        if (values.isEmpty()) {
            return values
        }

        val len = values.size

        // Selection sort is performed by recursively checking for the smallest value
        // when compared with the left most element in the array.
        for (i in 0 until len) {

            // Initially assuming that the first element from the left is the minimum.
            var minIndex = i

            // Starting from the second element, if any element is smaller than the
            // element at minimum index, the index of that element is assigned to the
            // minimum index value.
            // This process is repeated by decreasing the range starting with the left most
            // unsorted element until the whole array is sorted.
            for (j in (i + 1) until len) {
                if (values[minIndex] > values[j]) minIndex = j
            }

            // Swapping the smallest element with the left most unsorted element in the
            // array.
            val temp = values[minIndex]
            values[minIndex] = values[i]
            values[i] = temp
        }

        return values
    }
}

/**
 * Example function to perform sort on an unsorted array.
 */
fun selectionSortExample() {
    val sort: Sort<Int> = SelectionSort()
    val unsortedArray = arrayOf(20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
    print("\n\nTime taken in milli seconds (Selection Sort): ${measureTimeMillis { sort.sort(unsortedArray).forEach { print("$it ") } }}\n\n")
}