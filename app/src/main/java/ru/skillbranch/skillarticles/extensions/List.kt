package ru.skillbranch.skillarticles.extensions

fun List<Pair<Int, Int>>.groupByBounds(bounds: List<Pair<Int, Int>>): List<MutableList<Pair<Int, Int>>> {
    return bounds.fold(mutableListOf()) { acc, bound ->
        acc.also {
            acc.add(this.fold(mutableListOf()) { acc, el ->
                acc.also {
                    if (el.second > bound.first && el.first < bound.second) {
                        when {
                            el.first < bound.first ->
                                acc.add(Pair(bound.first, el.second))
                            el.second > bound.second ->
                                acc.add(Pair(el.first, bound.second))
                            else ->
                                acc.add(el)
                        }
                    }
                }
            })
        }
    }
}



