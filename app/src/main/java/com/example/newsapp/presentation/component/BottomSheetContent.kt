package com.example.newsapp.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.newsapp.R
import com.example.newsapp.domain.model.Article

@Composable
fun BottomSheetContent(
    article: Article,
    onReadFullStoryButtonClicked: () -> Unit,
) {
    Surface(modifier = Modifier.padding(16.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            article.title?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.titleMedium,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),   // new
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = article.description ?: "",
                style = MaterialTheme.typography.bodyMedium,
                fontFamily = FontFamily(Font(R.font.popins_regular)),   // new

            )
            Spacer(modifier = Modifier.height(8.dp))
            ImageHolder(imageUrl = article.urlToImage)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = article.content ?: "",
                style = MaterialTheme.typography.bodyMedium,
                fontFamily = FontFamily(Font(R.font.popins_regular)),   // new
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = article.author ?: "",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),   // new
                )
                Text(
                    text = article.source.name ?: "",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),   // new
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = onReadFullStoryButtonClicked,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Read Full Story",
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),   // new
                )
            }

        }
    }
}