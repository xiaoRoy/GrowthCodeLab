package com.learn.growthcodelab.recycler.group.sample

class Category(
        val id: String,
        val name: String,
        val subCategories: List<SubCategory>
)

class SubCategory(
        val id: String,
        val name: String
)


fun generateCategories(): List<Category> {
    val categoryNames = mapOf("categoryA" to 'a'..'h', "categoryB" to 'h'..'m', "categoryC" to 'o'..'x')
    return categoryNames.map {
        Category(it.key, it.key, generateSubCategory(it.value, it.key))
    }
}

private fun generateSubCategory(charRange: CharRange, categoryName: String): List<SubCategory> {
    return charRange.map { SubCategory(it.toString(), "$categoryName:$it") }
}