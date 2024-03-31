package com.example.littlelemon

import androidx.annotation.DrawableRes

object DishRepository {
    val dishes = listOf(
        Dish(1,"Black tea", 3.00, "Drinks", "A traditional hot beverage made from steeping tea leaves.", R.drawable.black_tea),
        Dish(2,"Green tea", 3.00, "Drinks", "A type of tea that is made from Camellia sinensis leaves and buds.", R.drawable.green_tea),
        Dish(3,"Espresso", 5.00, "Drinks", "A concentrated form of coffee made by forcing hot water under pressure through finely-ground coffee beans.", R.drawable.espresso),
        Dish(4,"Cappuccino", 8.00, "Drinks", "An espresso-based coffee drink that originated in Italy, prepared with double espresso, hot milk, and steamed milk foam.", R.drawable.cappuccino),
        Dish(5,"Latte", 8.00, "Drinks", "A coffee drink made with espresso and steamed milk.", R.drawable.latte),
        Dish(6,"Mocha", 10.00, "Drinks", "A type of coffee made from espresso and hot milk, often with added chocolate flavoring and sweeteners.", R.drawable.mocha),
        Dish(7,"Boeuf bourguignon", 15.00, "Main", "A traditional French beef stew made with red wine, beef, onions, carrots, garlic, and mushrooms.", R.drawable.boeuf_bourguignon),
        Dish(8,"Bouillabaisse", 20.00, "Main", "A traditional Provençal fish stew originating from the port city of Marseille.", R.drawable.bouillabaisse),
        Dish(9,"Lasagna", 15.00, "Main", "A classic Italian dish made with layers of pasta, meat sauce, and cheese.", R.drawable.lasagna),
        Dish(10,"Onion soup", 12.00, "Starter", "A type of soup usually based on meat stock and onions, and often served gratinéed with croutons and cheese on top.", R.drawable.onion_soup),
        Dish(11,"Salmon en papillote", 25.00, "Starter", "A method of cooking fish in a parchment packet, along with vegetables, herbs, and seasonings.", R.drawable.salmon_en_papillote),
        Dish(12,"Quiche Lorraine", 17.00, "Dessert", "A savory tart made with a filling of eggs, cream, cheese, and bacon or ham.", R.drawable.quiche_lorraine),
        Dish(13,"Custard tart", 14.00, "Dessert", "A type of dessert tart consisting of an outer pastry crust filled with egg custard.", R.drawable.custard_tart),
        Dish(14,"Croissant", 7.00, "Dessert", "A buttery, flaky, crescent-shaped pastry of Austrian origin, commonly eaten for breakfast or as a snack.", R.drawable.croissant)
    )

    fun getDish(id: Int) = dishes.firstOrNull { it.id == id }

    fun filterBy(filter: FilterType): List<Dish>{
        return when(filter){
                FilterType.All -> dishes
                FilterType.Dessert -> dishes.filter {it.category == "Dessert"}
                FilterType.Drink -> dishes.filter {it.category == "Drink"  }
                FilterType.Main -> dishes.filter {it.category == "Main"  }
                FilterType.Starter -> dishes.filter {it.category == "Starter"  }
            }
    }

}


data class Dish(
    val id: Int,
    val name: String,
    val price: Double,
    val category: String,
    val description: String,
    @DrawableRes val imageResource: Int
)
