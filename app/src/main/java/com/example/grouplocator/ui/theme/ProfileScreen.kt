package com.example.grouplocator.ui.theme

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.grouplocator.R

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        ProfilePicture()
        Username(username = "afiqkhairir")
    }
}

@Composable
fun ProfilePicture() {
    val context = LocalContext.current
    Card(shape = CircleShape, modifier = Modifier
        .padding(top = 90.dp, bottom = 10.dp)
        .clip(shape = CircleShape)
        .clickable {
            Toast
                .makeText(context, "Clicked!", Toast.LENGTH_SHORT)
                .show()
        }) {
        Image(painter = painterResource(id = R.drawable.pfp_default),
            contentDescription = "default profile picture",
            alignment = Alignment.Center,
            modifier = Modifier
                .size(90.dp)
                .padding(7.dp),
            colorFilter = ColorFilter.tint(color = Color.LightGray))
    }
}

@Composable
fun Username(username: String) {
    Text(text = "@${username}")
}