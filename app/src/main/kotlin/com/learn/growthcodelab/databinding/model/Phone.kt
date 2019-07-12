package com.learn.growthcodelab.databinding.model

class Phone(
        private val id: String,
        val brand: String,
        var price: Double,
        var color: String,
        val model: String = "model"
)