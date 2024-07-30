package uk.ac.tees.mad.w9608503.recipeapp.views.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController

@Composable
fun BlankView(navController: NavController) {

    LaunchedEffect(Unit) {
            navController.navigate("Login")
    }
}