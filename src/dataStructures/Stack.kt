package dataStructures

class Stack<T> : StackOperations<T> {

    private var size = 0
    private var head: Node? = null

    override fun push(value: T) {
        // Initializing the head node by adding latest value to the
        // head and assigning the previous head node as head's next node.
        head = Node(value, head)
        size++
    }

    override fun pop() {
        // Popping the latest data from the list by  assigning the next (previous)
        // value of the head to the current value.
        head = head?.next
        if (size > 0) size--
    }

    override fun peek() = head?.value // Returning the latest value without popping.

    override fun inEmpty() = size <= 0

    override fun size() = size

    /**
     * Function to print all the currently available elements in the Stack.
     */
    fun printList() {
        println()
        var temp = head
        while (temp != null) {
            print("${temp.value} ")
            temp = temp.next
        }
    }

    /**
     * [Node] for the Linked List implementation of the [Stack].
     */
    inner class Node(val value: T, var next: Node? = null)
}

/**
 * All the operations that can be performed using a stack.
 */
interface StackOperations<T> {
    fun push(value: T)
    fun pop()
    fun peek(): T?
    fun inEmpty(): Boolean
    fun size(): Int
}


/**
 * Example function to run the Stack logic and check for its operations.
 */
fun stackExample() {
    val stack = Stack<Int>()

    stack.push(1)
    stack.push(2)
    stack.push(3)

    println()
    stack.printList()

    stack.pop()

    println()
    stack.printList()

    stack.push(3)
    stack.push(4)
    stack.push(5)

    println()
    stack.printList()

    stack.pop()

    println()
    stack.printList()
}