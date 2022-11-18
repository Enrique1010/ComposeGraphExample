package com.erapps.graphsexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erapps.graphsexample.ui.theme.GraphsExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraphsExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CustomGraphicCard()
                }
            }
        }
    }
}

@Composable
fun CustomGraphicCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp)
            .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
    ) {
        Text(text = "Title")
        Spacer(modifier = Modifier.height(16.dp))
        Graph()
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Chip")
    }
}

@Composable
fun Graph(
    listx: List<Int> = listOf(5, 60, 20, 30, 40, 50, 600, 70, 80, 90, 500, 5, 60, 20, 30, 40, 50, 600, 70, 80, 90, 500)
) {

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(150.dp)
    ) {
        val width = size.width
        val height = size.height
        val step = width / listx.size
        val max = listx.maxOrNull() ?: 0
        val min = listx.minOrNull() ?: 0
        val stepY = height / (max - min)
        val path = Path()
        path.moveTo(0f, height - (listx[0] - min) * stepY)
        for (i in 1 until listx.size) {
            path.lineTo(i * step, height - (listx[i] - min) * stepY)
        }
        drawPath(
            path = path,
            color = Color.Blue,
            style = Stroke(
                width = 10f,
                pathEffect = PathEffect.cornerPathEffect(180.0f)
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    GraphsExampleTheme {
        CustomGraphicCard()
    }
}