package com.example.newsapp.presentation.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.newsapp.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryTabRow(
    pagerSate: PagerState,
    categories: List<String>,
    onTabSelected: (Int) -> Unit,
) {
    ScrollableTabRow(
        selectedTabIndex = pagerSate.currentPage,
        edgePadding = 0.dp,
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
    ) {
        categories.forEachIndexed { index, category ->
            Tab(
                modifier = Modifier.padding(horizontal = 30.dp),
                selected = pagerSate.currentPage == index,
                onClick = { onTabSelected(index) },
                content = {
                    Text(
                        text = category,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 2.dp),
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.popins_regular)),   // new
                    )
                }
            )
        }
    }
}