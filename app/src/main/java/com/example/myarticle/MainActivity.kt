package com.example.myarticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myarticle.ui.theme.MyArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Article(title = stringResource(R.string.title), intro = stringResource(R.string.intro), body = stringResource(R.string.body))
                }
            }
        }
    }
}

@Composable
fun Article(title: String, intro:String, body: String) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column{
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            //contentScale = ContentScale.Crop
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .wrapContentWidth(align = Alignment.Start )
                .padding(16.dp)
        )
        Text(
            text = intro,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .wrapContentWidth(align = Alignment.Start)
                .padding(16.dp)
        )
        Text(
            text = body,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .wrapContentWidth(align = Alignment.Start)
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    MyArticleTheme {
        Article(title = stringResource(R.string.title), intro = stringResource(R.string.intro), body = stringResource(R.string.body))
    }
}