package rate_limiter

class SlidingWindowRateLimiter(
    val maxRetries: Int = 5, val windowLengthInMillis: Long = 1000
) : RateLimiter {

    val clientMap = mutableMapOf<String, ArrayDeque<Long>>()
    override fun isAllowed(clientId: String): Boolean {
        val now = System.currentTimeMillis()

        val requests = clientMap.getOrPut(clientId) { ArrayDeque() }

        while (requests.isNotEmpty() && now - requests.first() >= windowLengthInMillis)
            requests.removeFirst()

        if (requests.size < maxRetries) {
            requests.add(now)
            return true
        }
        return false

    }
}