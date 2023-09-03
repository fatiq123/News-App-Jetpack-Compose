package com.example.newsapp.utils

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.newsapp.presentation.article_screen.ArticleScreen
import com.example.newsapp.presentation.news_screen.NewsScreen
import com.example.newsapp.presentation.news_screen.viewmodels.NewsScreenViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraphSetup(
    navController: NavHostController,
) {
    val argKey = "web_url"
    NavHost(navController = navController, startDestination = "news_screen") {
        composable(route = "news_screen") {
            val viewModel: NewsScreenViewModel = hiltViewModel()
            NewsScreen(
                state = viewModel.state,
                onEvent = viewModel::onEvent,
                onReadFullStoryButtonClicked = { url ->
                    navController.navigate("article_screen?$argKey=$url")
                }
            )
        }
        composable(route = "article_screen?$argKey={$argKey}", arguments = listOf(
            navArgument(name = argKey) {
                type = NavType.StringType
            }
        )) { backStackEntry ->
            ArticleScreen(
                url = backStackEntry.arguments?.getString(argKey),
                onBackPressed = {
                    navController.navigateUp()
                },
            )
        }
    }
}
