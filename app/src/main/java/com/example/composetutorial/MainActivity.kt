package com.example.composetutorial

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.R.drawable
import com.example.composetutorial.ui.theme.ComposeTutorialTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(Message("Tirth Patel", "Android Developer"))
                }
            }
        }
    }
}

data class Message(val title: String, val body: String)

@Composable
fun Greeting(msg : Message) {
    // Add padding around our message
    Column(modifier = Modifier.padding(all = 8.dp)) {
        Row {
            Image(
                painter = painterResource(drawable.image),
                contentDescription = "Content Profile Picture",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(50.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
                    .border(
                        1.5.dp, MaterialTheme.colors.secondary, CircleShape
                    )
            )
            // Add a horizontal space between the image and the column
            Spacer(modifier = Modifier.width(8.dp))
            Column {

                Text(
                    text = "${msg.title}!",
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )
                // Add a vertical space between the author and message texts
                Spacer(modifier = Modifier.height(4.dp))

                Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp)
                {
                    Text(
                        text = "${msg.body}!",
                        Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            val context = LocalContext.current
            Button(onClick = {
                context.startActivity(Intent(context,ListOfMessage::class.java))
                Toast.makeText(context, "You are on second page!", Toast.LENGTH_SHORT).show();
            },
                 modifier = Modifier.padding(top = 10.dp)) {
                Text("Click")
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun DefaultPreview() {
    ComposeTutorialTheme {
        Greeting(
            msg = Message("Colleague", "Take a look at Jetpack Compose, it's great!")
        )
    }
}