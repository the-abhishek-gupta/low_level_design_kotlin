package rate_limiter

class FixedWindowRateLimiter(val maxRetries: Int = 5, val windowSizeInMillis: Long = 1000) : RateLimiter {
    val clientWindowsMap = mutableMapOf<String, WindowState>()

    @Synchronized
    override fun isAllowed(clientId: String): Boolean {
        val now = System.currentTimeMillis()
        val state = clientWindowsMap[clientId]

        if (state == null) {
            clientWindowsMap[clientId] = WindowState(windowStartTime = now, requestCount = 1)
            return true
        }
        val isWindowExpired = (now - state.windowStartTime) >= windowSizeInMillis

        if (isWindowExpired) {
            state.windowStartTime = now
            state.requestCount = 1
            return true
        }

        if (state.requestCount > maxRetries) return false

        state.requestCount++;
        return true

    }
}