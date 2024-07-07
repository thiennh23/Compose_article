package com.example.compose_article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.graphics.Color
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

@Composable
fun composeQuadrant() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.text_composable),
                color = Color(0xFFEADDFF),
                description = stringResource(R.string.displays_text_and_follows_the_recommended_material_design_guidelines),
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.image_composable),
                color = Color(0xFFD0BCFF),
                description = stringResource(R.string.image_text),
                modifier = Modifier.weight(1f)
            )
        }

        Row(modifier = Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.row_composable),
                color = Color(0xFFD0BCFF),
                description = stringResource(R.string.row_text),
                modifier = Modifier.weight(1f)
            )

            ComposableInfoCard(
                title = stringResource(R.string.column_composable),
                color = Color(0xFFEADDFF),
                description = stringResource(R.string.colum_text),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ComposableInfoCard(
    title: String,
    color: Color,
    description: String,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview
@Composable
fun composeQuadrantPreview() {
    composeQuadrant()
}

/*@Preview
@Composable
fun TaskManagerPreview() {
    Compose_articleTheme {
        TaskManager(imgPainter = painterResource(id = R.drawable.ic_task_completed),
            firstText = stringResource(id = R.string.task_completed),
            secondText = stringResource(R.string.nice_work),
            modifier = Modifier)
    }
}*/


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
