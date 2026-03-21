package rate_limiter

class RateLimiterMain {
    fun main() {
        val limiter = FixedWindowRateLimiter(
            maxRetries = 3,
            windowSizeInMillis = 5000

        )

        val clientId = "client_1"

        repeat(5) {
            println("Allowed: ${limiter.isAllowed(clientId)}")
        }
    }
}