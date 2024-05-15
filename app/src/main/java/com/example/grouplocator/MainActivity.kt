package com.example.grouplocator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grouplocator.ui.theme.GroupLocatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroupLocatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Greeting("Afiq")
                        UpcomingEvents()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Welcome Back, $name!",
        modifier = modifier
            .padding(20.dp, 20.dp, 0.dp, 20.dp),
        fontSize = 30.sp
    )
}

@Composable
fun UpcomingEvents(modifier: Modifier = Modifier) {
    Card (
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ){
        Text(text = "Scheduled Events",
            Modifier.padding(10.dp),
            fontWeight = FontWeight.Bold)
        Text(text = "No events scheduled! Add one now!", Modifier.padding(10.dp, 0.dp, 10.dp, 10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GroupLocatorTheme {
        Greeting("Android")
    }
}