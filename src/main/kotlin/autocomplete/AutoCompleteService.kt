package autocomplete

class AutoCompleteService(val topK: Int = 5) {
    private val trie: Trie = Trie(topK)
    fun recordQuery(query: String) {
        trie.insert(query)
    }

    fun addQueries(queries: List<String>) {
        queries.forEach { recordQuery(it) }
    }

    fun getSuggestionsWithFrequency(query: String): List<Suggestion> {
        return trie.search(query)
    }
    fun getSuggestions(query: String): List<String> {
        return trie.search(query).map { it.text }
    }
}