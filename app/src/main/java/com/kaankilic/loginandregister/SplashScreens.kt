package com.kaankilic.loginandregister
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kaankilic.loginandregister.ui.theme.LoginAndRegisterTheme

@Composable
fun FirstScreen(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.plan),
                contentDescription = "plan",
                Modifier
                    .size(width = 400.dp, height = 400.dp)
                    .padding(10.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            PageIndicator(pageCount = 3, currentPage = 0)
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Make a Travel Plan",
                modifier = Modifier.padding(16.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
        }

        IconButton(
            onClick = {
                navController.navigate("second screen")
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(33.dp, 50.dp)
                .size(50.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Geç",
                modifier = Modifier.size(50.dp),
                tint = Color.DarkGray,
            )
        }
    }
}

@Composable
fun SecondScreen(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.booking),
                contentDescription = "plan",
                Modifier
                    .size(width = 400.dp, height = 400.dp)
                    .padding(10.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            PageIndicator(pageCount = 3, currentPage = 1)
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Booking Your Hotel",
                modifier = Modifier.padding(2.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
            Text(
                text = "And Flight",
                modifier = Modifier.padding(2.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
        }

        IconButton(
            onClick = {
                navController.navigate("third screen")
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(33.dp, 50.dp)
                .size(50.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Geç",
                modifier = Modifier.size(50.dp),
                tint = Color.DarkGray,
            )
        }
    }

}

@Composable
fun ThirdScreen(navController: NavController)
{
    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(25.dp))
            Image(
                painter = painterResource(id = R.drawable.dunya),
                contentDescription = "plan",
                Modifier
                    .size(400.dp)
                    .padding(10.dp)
                    .scale(1f)
            )
            Spacer(modifier = Modifier.height(10.dp))

            PageIndicator(pageCount = 3, currentPage = 2)
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Enjoy Your Travel!",
                modifier = Modifier.padding(2.dp),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(40.dp))
            Button(onClick = {
                navController.navigate("login screen")
            }, modifier = Modifier
                .height(60.dp)
                .width(250.dp) ) {
                Text(text = "Let's Get Started", modifier = Modifier.padding(4.dp), fontSize = 20.sp, fontWeight = FontWeight.Bold)
                
            }
        }


    }

}

@Composable
fun PageIndicator(pageCount: Int, currentPage: Int) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        repeat(pageCount) { index ->
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(10.dp)
                    .background(
                        color = if (index == currentPage) MaterialTheme.colorScheme.primary else Color.Gray,
                        shape = CircleShape
                    )
            )
        }
    }
}




@Preview(showBackground = true)
@Composable
fun SplashReview() {
    LoginAndRegisterTheme {

    }
}