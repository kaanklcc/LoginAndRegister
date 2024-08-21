package com.kaankilic.loginandregister

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kaankilic.loginandregister.ui.theme.LoginAndRegisterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LoginAndRegisterTheme {
               SayfaGecisleri()

            }
        }
    }
}


@Composable
fun SayfaGecisleri(){
    val navController= rememberNavController()

    NavHost(navController = navController, startDestination = "first screen" ) {
        composable(route = "first screen"){
            FirstScreen(navController)
        }
        composable(route= "second screen"){
            SecondScreen(navController)
        }
        composable(route = "third screen"){
            ThirdScreen(navController)
        }

    }

}