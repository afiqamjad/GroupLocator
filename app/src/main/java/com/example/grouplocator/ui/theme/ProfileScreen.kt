package com.example.grouplocator.ui.theme

import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.grouplocator.R
import java.util.Date

data class Event(val id: Int, val date: Date, val title: String)

@Composable
fun ProfileScreen() {
    val events = listOf(
        Event(1, date = Date(), "Ethan's Party"),
        Event(2, date = Date(), "Nomikai"),
        Event(3, date = Date(), "Frat"),
        Event(4, date = Date(), "Nomikai 5"),
        Event(5, date = Date(), "Party @ Elena's"),
        Event(6, date = Date(), "Rando"),
        Event(7, date = Date(), "Cambridge Nomikai")
    )
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
        ) {
        ProfilePicture()
        Username(username = "afiqkhairir")
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Past Events",
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 15.dp, end = 0.dp, top = 15.dp, bottom = 4.dp),
                fontWeight = FontWeight.SemiBold
            )
            PastEventsList(events = events)
        }
        LogoutButton  {
            println("Hello")
        }
    }
}

@Composable
fun ProfilePicture() {
    val context = LocalContext.current
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri: Uri? ->
        imageUri = uri
    }
    Card(shape = CircleShape, modifier = Modifier
        .padding(top = 90.dp, bottom = 10.dp)
        .clip(shape = CircleShape)
        .clickable {
            launcher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }) {
        Box(
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
        ) {
            if (imageUri != null) {
                Image(
                    painter = rememberAsyncImagePainter(imageUri),
                    contentDescription = "selected profile picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.pfp_default),
                    contentDescription = "default profile picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),
                    colorFilter = ColorFilter.tint(color = Color.LightGray)
                )
            }
        }
    }
}

@Composable
fun PastEventsCard(event: Event) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()

    ){
        Column {
            Text(text = event.title, fontSize = 20.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(3.dp))
            Text(text = event.date.toString(), fontSize = 14.sp, color = Color.Gray)
        }
    }
}

@Composable
fun PastEventsList(events: List<Event>) {
    Card (
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .heightIn(min = 0.dp, max = 215.dp)
    ){
        LazyColumn(modifier = Modifier.padding(5.dp)) {
            items(events) {event ->
                PastEventsCard(event = event)
            }
        }
    }
}

@Composable
fun LogoutButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 12.dp,
            disabledElevation = 0.dp
        ),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 25.dp)
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(text = "Logout", fontSize = 18.sp)
    }
}

@Composable
fun Username(username: String) {
    Text(text = "@${username}")
}