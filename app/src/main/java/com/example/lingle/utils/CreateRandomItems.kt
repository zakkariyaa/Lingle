package com.example.lingle.utils

fun createRandomItems(array: ArrayList<Item>): ArrayList<Item> {
    val randomItems = arrayListOf<Item>()
    while (randomItems.size < 5) {
        val random = java.util.Random()
        val randomItem = array[random.nextInt(array.size)]
        if (!randomItems.contains(randomItem)){
            randomItems.add(randomItem)
        }
    }
    return randomItems
}

fun randomItems(category: String?): ArrayList<Item>? {
    return categories.find { it.name == category }
        ?.let { createRandomItems(it.items) }
}