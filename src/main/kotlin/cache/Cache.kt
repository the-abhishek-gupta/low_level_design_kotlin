package org.example.cache

class Cache(capacity: Int = 5) {
    private val capacity = capacity.coerceAtLeast(0)
    private var map: MutableMap<Int, Node> = mutableMapOf()
    private val head = Node()
    val tail = Node()

    init {
        head.next = tail
        tail.prev = head
    }


    fun get(x: Int): Int {
        val node = map[x] ?: return -1
        moveToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (capacity == 0)
            return
        val existingNode = map[key]
        if (existingNode != null) {
            existingNode.value = value
            moveToHead(existingNode)
            return
        }
        if (map.size == capacity) {
            val lru = tail.prev
            if (lru != null && lru.prev != head) {
                removeNode(tail.prev!!)
                map.remove(lru.key)
            }
        }
        val newNode = Node(key, value)
        map[key] = newNode
        addToHead(newNode)

    }

    private fun moveToHead(node: Node) {
        removeNode(node)
        addToHead(node)
    }

    private fun addToHead(node: Node) {
        val nextNode = head.next
        head.next = node
        node.next = nextNode
        node.prev = head
        nextNode?.prev = node

    }

    private fun removeNode(node: Node) {
        val nextNode = node.next
        val prevNode = node.prev
        nextNode?.prev = prevNode
        prevNode?.next = nextNode
        map.remove(node.value)
        node.next = null
        node.prev = null
    }
}

data class Node(val key: Int = -1, var value: Int = -1, var next: Node? = null, var prev: Node? = null)