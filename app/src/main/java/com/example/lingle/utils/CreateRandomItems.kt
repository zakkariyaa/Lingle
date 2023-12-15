package com.example.lingle.utils

fun createRandomItems(array: ArrayList<Item>): ArrayList<Item> {
    val randomItems = arrayListOf<Item>()
    for (i in 1..5) {
        val random = java.util.Random()
        val randomItem = array[random.nextInt(array.size)]
        randomItems.add(randomItem)
    }

    return randomItems
}

fun randomItems(): HashMap<String, ArrayList<Item>?> {
    val randomFruits = categories.find { it.name == "Fruits" }
        ?.let { createRandomItems(it.items) }
    val randomColours = categories.find { it.name == "Colours" }
        ?.let { createRandomItems(it.items) }
    val randomVegetables = categories.find { it.name == "Vegetables" }
        ?.let { createRandomItems(it.items) }
    val randomAnimals = categories.find { it.name == "Animals" }
        ?.let { createRandomItems(it.items) }

    return hashMapOf<String, ArrayList<Item>?>(
        "fruits" to randomFruits,
        "colours" to randomColours,
        "vegetables" to randomVegetables,
        "animals" to randomAnimals,
    )
}