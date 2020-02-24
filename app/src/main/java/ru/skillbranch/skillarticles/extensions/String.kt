package ru.skillbranch.skillarticles.extensions

fun String?.indexesOf(substr: String, ignoreCase: Boolean = true): List<Int> {
    if (this.isNullOrBlank() || substr.isBlank()) return emptyList()
    val list = mutableListOf<Int>()
    var index = this.indexOf(string = substr, ignoreCase = ignoreCase)

    while (index != -1) {
        list.add(index)
        index += substr.length
        index = this.indexOf(substr, index, ignoreCase)
    }
    return list
}