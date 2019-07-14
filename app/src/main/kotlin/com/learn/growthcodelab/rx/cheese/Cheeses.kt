package com.learn.growthcodelab.rx.cheese

class Cheese(
        val name: String
) {

    companion object {
        val cheeses = mapOf(
                "AAA" to listOf(Cheese("A1-Cheese"), Cheese("A2-Cheese"), Cheese("A2-Cheese")),
                "BBB" to listOf(Cheese("B1-Cheese"), Cheese("B2-Cheese"), Cheese("B3-Cheese"),
                        Cheese("B4-Cheese")),
                "CCC" to listOf(Cheese("C1-Cheese"), Cheese("C2-Cheese"), Cheese("C3-Cheese"),
                        Cheese("C4-Cheese"), Cheese("C5-Cheese")))

        val defaultCheese = listOf(Cheese("Cheese-First"), Cheese("Cheese-Second"), Cheese("Cheese-Fourth"),
                Cheese("Cheese-Fifth"))
    }

}