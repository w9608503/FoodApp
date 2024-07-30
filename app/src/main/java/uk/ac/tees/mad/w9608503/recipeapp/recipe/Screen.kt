package uk.ac.tees.mad.w9608503.recipeapp.recipe

sealed class Screen(val route: String) {
    object RecipeScreen: Screen("recipescreen")
    object DetailScreen: Screen("detailscreen")
}