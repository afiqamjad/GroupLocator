package com.example.grouplocator.ui.theme

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
    val context = LocalContext.current
    Column (modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        EmailBox(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp))
        PasswordBox(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, bottom = 25.dp))
        LoginButton {
            Toast.makeText(context, "Login Button Clicked!", Toast.LENGTH_SHORT).show()
        }
        SignUpButton {
            Toast.makeText(context, "Sign Up Button Clicked!", Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
fun EmailBox(modifier: Modifier) {
    val email = remember { mutableStateOf("") }

    OutlinedTextField(
        value = email.value,
        onValueChange = { email.value = it },
        label = { Text("Email") },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
        modifier = modifier
    )
}

@Composable
fun PasswordBox(modifier: Modifier) {
    val password = remember { mutableStateOf("") }

    OutlinedTextField(
        value = password.value,
        onValueChange = { password.value = it },
        label = { Text("Password") },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation(),
        modifier = modifier
    )
}

@Composable
fun LoginButton(onClick: () -> Unit) {
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
        Text(text = "Login", fontSize = 18.sp)
    }
}

@Composable
fun SignUpButton(onClick: () -> Unit) {
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
        Text(text = "Sign Up", fontSize = 18.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}