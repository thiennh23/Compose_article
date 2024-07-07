package com.example.compose_article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_article.ui.theme.Compose_articleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_articleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    /*TextDisplay(
                        title = stringResource(id = R.string.tittle),
                        shortText = stringResource(id = R.string.firstPara),
                        longText = stringResource(id = R.string.secondPara),
                        imgPainter = painterResource(id = R.drawable.bg_compose_background),
                        modifier = Modifier.padding(innerPadding)
                    )*/

                    TaskManager(imgPainter = painterResource(id = R.drawable.ic_task_completed),
                        firstText = stringResource(id = R.string.task_completed),
                        secondText = stringResource(R.string.nice_work),
                        modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// Android default font size is: 14sp
@Composable
fun TextDisplay(
    title: String,
    shortText: String,
    longText: String,
    imgPainter: Painter,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Image(painter = imgPainter, contentDescription = null)
        Text(text = title, fontSize = 24.sp, modifier = modifier.padding(16.dp))
        Text(text = shortText, modifier = modifier.padding(start = 16.dp, end = 16.dp), textAlign = TextAlign.Justify)
        Text(text = longText, modifier = modifier.padding(16.dp), textAlign = TextAlign.Justify)

    }
}

@Composable
fun TaskManager(
    imgPainter: Painter,
    firstText: String,
    secondText: String,
    modifier: Modifier
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = imgPainter, contentDescription = null)
        Text(
            text = firstText,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(text = secondText, fontSize = 16.sp, textAlign = TextAlign.Justify)
    }
}

@Preview
@Composable
fun TaskManagerPreview() {
    Compose_articleTheme {
        TaskManager(imgPainter = painterResource(id = R.drawable.ic_task_completed),
            firstText = stringResource(id = R.string.task_completed),
            secondText = stringResource(R.string.nice_work),
            modifier = Modifier)
    }
}


/*@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_articleTheme {
        TextDisplay(title = stringResource(id = R.string.tittle),
            shortText = stringResource(id = R.string.firstPara),
            longText =stringResource(id = R.string.secondPara),
            imgPainter = painterResource(id = R.drawable.bg_compose_background),
            modifier = Modifier
        )
    }
}*/
