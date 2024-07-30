package uk.ac.tees.mad.w9608503.foodapp.food

sealed class Screen(val route: String) {
    object RecipeScreen: Screen("recipescreen")
    object DetailScreen: Screen("detailscreen")
}