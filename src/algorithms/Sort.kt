package algorithms

/**
 * Behaviour for performing sort operation on a give array.
 */
interface Sort<T> {
    fun sort(values: Array<T>): Array<T>
}