package com.kaankilic.loginandregister

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kaankilic.loginandregister.ui.theme.LoginAndRegisterTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var scale = remember { androidx.compose.animation.core.Animatable(0f) }
    var showOnlyImage by remember { mutableStateOf(false) }
    var animationCompleted by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = showOnlyImage) {
        if (showOnlyImage) {
            scale.animateTo(
                targetValue = 1f,
                animationSpec = tween(
                    durationMillis = 2000,
                    easing = { OvershootInterpolator(2f).getInterpolation(it) }
                )
            )
            animationCompleted = true
            kotlinx.coroutines.delay(3000)
            navController.navigate("login screen")
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {


        Image(
            painter = painterResource(id = R.drawable.yelkenn),
            contentDescription = "pisa",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .padding(1.dp)
                .align(Alignment.TopStart),

            alpha = if (showOnlyImage) 0f else 0.65f
        )

        if (!showOnlyImage) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(100.dp))
                Text(
                    text = "CREATE A NEW ", fontSize = 45.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "ACCOUNT ", fontSize = 45.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    placeholder = {
                        Text(
                            text = "Name", style = TextStyle(
                                fontSize = 20.sp, color = Color.Black
                            ), fontWeight = FontWeight.Bold
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFFf8f8ff)),
                    textStyle = TextStyle(
                        fontSize = 20.sp, fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = {
                        Text(
                            text = "Email Address", style = TextStyle(
                                fontSize = 20.sp, color = Color.Black
                            ), fontWeight = FontWeight.Bold
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFFf8f8ff)),
                    textStyle = TextStyle(
                        fontSize = 20.sp, fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = {
                        Text(
                            text = "Password", style = TextStyle(
                                fontSize = 20.sp, color = Color.Black
                            ), fontWeight = FontWeight.Bold
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFFf8f8ff)),
                    visualTransformation = PasswordVisualTransformation()
                )

                Button(onClick = {
                    showOnlyImage = true
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)) {
                    Text(
                        text = "Signup", modifier = Modifier
                            .align(Alignment.CenterVertically), fontSize = 20.sp
                    )
                }


                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Or register", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Google",
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(60.dp)
                            .clickable { }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ig),
                        contentDescription = "Instagram",
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(60.dp)
                            .clickable { }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.x),
                        contentDescription = "X",
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(60.dp)
                            .clickable { }
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))


            }
        }

        AnimatedVisibility(visible = showOnlyImage) {
            Image(
                painter = painterResource(id = R.drawable.register),
                contentDescription = "world logo",
                modifier = Modifier
                    .size(800.dp)
                    .scale(scale.value)
            )
        }
    }
}



