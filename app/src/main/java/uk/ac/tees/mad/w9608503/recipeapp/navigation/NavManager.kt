package uk.ac.tees.mad.w9608503.recipeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uk.ac.tees.mad.w9608503.recipeapp.viewModel.LoginViewModel
import uk.ac.tees.mad.w9608503.recipeapp.views.login.BlankView
import uk.ac.tees.mad.w9608503.recipeapp.views.login.TabsView
import uk.ac.tees.mad.w9608503.recipeapp.views.HomeView
import uk.ac.tees.mad.w9608503.recipeapp.recipe.Category
import uk.ac.tees.mad.w9608503.recipeapp.recipe.CategoryDetailScreen
import uk.ac.tees.mad.w9608503.recipeapp.recipe.MainViewModel
import uk.ac.tees.mad.w9608503.recipeapp.recipe.RecipeScreen

@Composable
fun NavManager(loginViewModel: LoginViewModel) {
    
    val navController = rememberNavController()
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState
    NavHost(navController = navController, startDestination = "Blank" ){

        composable("Blank"){
           BlankView(navController)
        }
        composable("Login"){
            TabsView(navController,loginViewModel)
        }
        composable("Home"){
            HomeView(navController = navController)
        }
        composable("RecipeScreen"){
            RecipeScreen(navController, viewState = viewState) {
                //Pass data from current screen to the detail screen
                navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                navController.navigate("DetailsScreen")
            }
        }
        composable("DetailsScreen"){
            val category = navController.previousBackStackEntry?.savedStateHandle?.
            get<Category>("cat") ?: Category("", "", "", "")
            CategoryDetailScreen(category = category)
        }
    }
}