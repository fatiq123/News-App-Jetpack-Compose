package com.example.newsapp.presentation.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.newsapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreenTopAppBar(
    scrollBehavior: TopAppBarScrollBehavior,
    onSearchIconClicked: () -> Unit
) {
    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(text = "NewsApp",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.popins_regular)),   // new
            )
        },
        actions = {
            IconButton(onClick = { onSearchIconClicked() }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}
