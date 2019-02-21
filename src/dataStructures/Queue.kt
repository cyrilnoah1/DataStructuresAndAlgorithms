package dataStructures

class Queue<T> : QueueOperations<T> {

    private var size = 0
    private var head: Node? = null

    override fun enqueue(value: T) {
        // Initializing the head node by adding latest value to the
        // head and assigning the previous head node as head's next node.
        head = Node(value, head)
        size++
    }

    override fun dequeue() {
        // If there is only one node in the list, deleting the node directly.
        if (head?.next == null) {
            head = null
        }
        // Else, if there is more than one node, we shift all the nodes one step
        // ahead and delete the first node from the list.
        else {

            var last = head
            var prev: Node? = null

            while (last?.next != null) {
                prev = last
                last = last.next
            }

            prev?.next = null
        }

        if (size > 0) size--
    }

    override fun peek() = head?.value

    override fun size() = size

    override fun isEmpty() = size <= 0


    /**
     * Function to print all the items in the queue.
     */
    fun printList() {
        var temp = head
        while (temp != null) {
            print("${temp.value} ")
            temp = temp.next
        }
    }

    /**
     * [Node] for Linked List implementation of the [Queue].
     */
    inner class Node(val value: T, var next: Node? = null)
}

/**
 * All the operations that can be performed using a queue.
 */
interface QueueOperations<T> {
    fun enqueue(value: T)
    fun dequeue()
    fun peek(): T?
    fun size(): Int
    fun isEmpty(): Boolean
}

/**
 * Example function to show the implementation of queue.
 */
fun queueExample() {
    val queue = Queue<Int>()
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    queue.enqueue(4)

    println()
    queue.printList()

    queue.dequeue()
    queue.dequeue()

    println()
    queue.printList()

    queue.enqueue(1)
    queue.enqueue(2)

    println()
    queue.printList()

    queue.dequeue()

    println()
    queue.printList()
}