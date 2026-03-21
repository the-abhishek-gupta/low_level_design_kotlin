package rate_limiter

data class WindowState(var windowStartTime: Long, var requestCount: Int)
