package notification.service

class RetryService(
    private val maxRetries: Int = 3
) {
    suspend fun performRetry(executableBlock: suspend () -> Unit) {
        repeat(maxRetries) { attempt ->
            try {
                executableBlock()
                return
            } catch (e: Exception) {
                if (attempt == maxRetries - 1)
                    throw e
                else
                    println("Retrying $attempt")
            }
        }
    }
}