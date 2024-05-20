package com.example.grouplocator.ui.theme

import android.graphics.drawable.shapes.Shape
import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
    Card(shape = RoundedCornerShape(100), modifier = Modifier.padding(top = 50.dp, bottom = 10.dp)) {
        Text(text = "Hello", modifier = Modifier.padding(10.dp))
    }
}

@Composable
fun Username(username: String) {
    Text(text = "@${username}")
}