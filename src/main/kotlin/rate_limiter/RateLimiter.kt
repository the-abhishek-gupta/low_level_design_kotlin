package rate_limiter

interface RateLimiter {

    fun isAllowed(clientId : String): Boolean
}

