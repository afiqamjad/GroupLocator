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
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column (modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        EmailBox(
            email = email.value,
            onEmailChange = { email.value = it },
            modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp))
        PasswordBox(password = password.value,
            onPasswordChange = { password.value = it },
            modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, bottom = 25.dp))
        LoginButton(email = email.value, password = password.value, onClick = { submittedEmail, submittedPassword ->
            Toast.makeText(context, "Login Button Clicked! Email: $submittedEmail, Password: $submittedPassword", Toast.LENGTH_SHORT).show()
        })
        SignUpButton (email = email.value, onClick = {
            Toast.makeText(context, "Sign Up Button Clicked!", Toast.LENGTH_SHORT).show()
        })
    }
}

@Composable
fun EmailBox(email: String, onEmailChange: (String) -> Unit, modifier: Modifier) {
    OutlinedTextField(
        value = email,
        onValueChange = onEmailChange,
        label = { Text("Email") },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
        modifier = modifier
    )
}

@Composable
fun PasswordBox(password: String, onPasswordChange: (String) -> Unit, modifier: Modifier) {
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = { Text("Password") },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation(),
        modifier = modifier
    )
}

@Composable
fun LoginButton(email: String, password: String, onClick: (String, String) -> Unit) {
    Button(
        onClick = { onClick(email, password) },
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
            .padding(start = 46.dp, end = 46.dp, bottom = 15.dp)
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(text = "Login", fontSize = 18.sp)
    }
}

@Composable
fun SignUpButton(email: String, onClick: (String) -> Unit) {
    Button(
        onClick = { onClick(email) },
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
            .padding(start = 46.dp, end = 46.dp, bottom = 25.dp)
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