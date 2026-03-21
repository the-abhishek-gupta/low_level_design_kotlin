package autocomplete


class Trie(val topK: Int = 5) {

    private val root = TrieNode()
    fun insert(word: String, increment: Int = 1) {
        if (word.isEmpty()) return
        val searchWord = normalizeWord(word)
        var node = root
        for (c in searchWord) {
            node = node.children.getOrPut(c) { TrieNode() }
            updateTopSuggestions(node, searchWord, increment)
        }
        node.isEnd = true
    }

    fun search(prefix: String): List<Suggestion> {
        if (prefix.isEmpty()) return emptyList()
        val normalizedPrefix = normalizeWord(prefix)
        var node = root
        for (c in normalizedPrefix) {
            node = node.children[c] ?: return emptyList()
        }
        return node.topSuggestions.map { Suggestion(it.key, it.value) }
            .sortedWith(compareByDescending<Suggestion> { it.frequency }.thenBy { it.text })
    }

    private fun updateTopSuggestions(node: TrieNode, searchWord: String, increment: Int) {
        val newFrequency = (node.topSuggestions[searchWord] ?: 0) + increment
        node.topSuggestions[searchWord] = newFrequency

        if (node.topSuggestions.size > topK) {
            val sorted =
                node.topSuggestions.entries.sortedWith(compareByDescending<Map.Entry<String, Int>> { it.value }.thenBy { it.key })
                    .take(topK)
            node.topSuggestions.clear()
            sorted.forEach { node.topSuggestions[it.key] = it.value }
        }
    }

    private fun normalizeWord(word: String) = word.trim().lowercase()


}