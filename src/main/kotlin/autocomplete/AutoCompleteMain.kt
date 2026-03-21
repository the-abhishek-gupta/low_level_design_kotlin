package autocomplete

class AutoCompleteMain {
    fun main() {
        val service = AutoCompleteService()
        service.addQueries(
            listOf(
                "apple",
                "app",
                "application",
                "apply",
                "app",
                "apple",
                "appetite",
                "banana",
                "band",
                "bandana",
                "app",
                "apple pie",
                "apple watch",
                "apple",
                "application"
            )
        )

        println("Suggestions for 'app':")
        println(service.getSuggestions("app"))

        println()
        println("Suggestions with frequency for 'app':")
        service.getSuggestionsWithFrequency("app").forEach {
            println("${it.text} -> ${it.frequency}")
        }

        println()
        println("Suggestions for 'ban':")
        println(service.getSuggestions("ban"))

    }
}