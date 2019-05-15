package com.agoda.ninjato.misc

internal fun MutableMap<String, MutableList<String>>.add(pair: Pair<String, String>) {
    if (this[pair.first] != null) {
        this[pair.first]?.add(pair.second)
    } else {
        this[pair.first] = mutableListOf(pair.second)
    }
}

internal fun MutableMap<String, MutableList<String>>.addAll(pair: Pair<String, Iterable<String>>) {
    if (this[pair.first] != null) {
        this[pair.first]?.addAll(pair.second)
    } else {
        this[pair.first] = pair.second.toMutableList()
    }
}

internal fun MutableMap<String, MutableList<String>>.addAll(map: Map<String, Iterable<String>>) {
    for ((key, value) in map) addAll(key to value)
}
