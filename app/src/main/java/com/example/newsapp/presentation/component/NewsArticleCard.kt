package com.example.newsapp.presentation.component

import android.graphics.fonts.FontStyle
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.newsapp.R
import com.example.newsapp.domain.model.Article
import com.example.newsapp.utils.dateFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NewsArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onCardClicked: (Article) -> Unit,
) {
    val date = dateFormatter(article.publishedAt)

    Card(
        modifier = modifier
            .padding(top = 15.dp, start = 15.dp, end = 15.dp)   // there was no padding here before
            .clickable {
                onCardClicked(article)
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(modifier = modifier.padding(0.dp)) {// before padding was 12.dp
            ImageHolder(imageUrl = article.urlToImage)
            Text(
                modifier = modifier.padding(top = 5.dp, start = 5.dp),    // no padding here before
                text = article.title ?: "Default value",
                style = MaterialTheme.typography.titleMedium,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),   // new
//                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = modifier.height(8.dp))
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = article.source.name ?: "",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,                   // new
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),   // new
                    modifier = modifier.padding(start = 5.dp)       // also here
                )
                Text(
                    text = date,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,                   // new
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),   // new
                    modifier = modifier.padding(end = 10.dp)       // also here
                )
            }
        }
    }
}