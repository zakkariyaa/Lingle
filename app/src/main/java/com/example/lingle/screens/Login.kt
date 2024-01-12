package com.example.lingle.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.lingle.LoadingComponent
import com.example.lingle.SupabaseAuthViewModel
import com.example.lingle.data.model.UserState

@Composable
fun LoginScreen(
    viewModel: SupabaseAuthViewModel = viewModel(),
    navController: NavHostController
) {
    val context = LocalContext.current
    val userState by viewModel.userState

    var userEmail by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }

    var currentUserState by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        viewModel.isUserLoggedIn(context)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = userEmail,
                onValueChange = { userEmail = it },
                placeholder = {
                    Text(text = "Email")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                }
            )

            TextField(
                value = userPassword,
                onValueChange = { userPassword = it },
                placeholder = {
                    Text(text = "Password")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = null)
                }
            )

            Button(
                onClick = {
                    viewModel.login(
                        context = context,
                        userEmail = userEmail,
                        userPassword = userPassword
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(text = "Login")
            }

            // Button to navigate to the signup screen
            TextButton(
                onClick = {
                    navController.navigate("signup")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(text = "Don't have an account?")
            }

            when (userState) {
                is UserState.Loading -> {
//                    LoadingComponent()
                }

                is UserState.Success -> {
                    val message = (userState as UserState.Success).message
                    currentUserState = message
                }

                is UserState.Error -> {
                    val message = (userState as UserState.Error).message
                    currentUserState = message
                }
            }

            if (currentUserState.isNotEmpty()) {
                Text(text = currentUserState)
            }
        }
    }
}