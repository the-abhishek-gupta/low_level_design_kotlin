package autocomplete

class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var isEnd = false
    val topSuggestions = mutableMapOf<String, Int>()
}