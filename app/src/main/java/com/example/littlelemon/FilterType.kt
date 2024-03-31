package com.example.littlelemon

sealed class FilterType(val name:String) {
    object All : FilterType("All")
    object Starter : FilterType("Starters")
    object Main : FilterType("Mains")
    object Dessert : FilterType("Desserts")
    object Drink : FilterType("Drinks")
}
