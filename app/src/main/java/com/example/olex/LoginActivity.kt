package com.example.olex

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.olex.ui.theme.OlexTheme
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.ui.graphics.graphicsLayer


class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OlexTheme {
                LoginScreen()

                }
            }
        }
    }


@Composable
fun LoginScreen (){
    var email by remember { mutableStateOf(value = "") }
    var password by remember{ mutableStateOf(value = "")  }
    var context = LocalContext.current
    Column  (modifier = Modifier
        .fillMaxSize()
        .background(Brush.verticalGradient(listOf(Color(0xFF64B5F6), Color(0xFF1976D2))))
        .padding(16.dp).fillMaxHeight().fillMaxWidth(), verticalArrangement = Arrangement.Center){
        Text(text = "Login here",
            fontSize = 40.sp,
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(40.dp))
        Image(painter = painterResource(R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .height(200.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(value = email,
            onValueChange = {newEmail -> email = newEmail},
            label = {Text(text = "Enter Email")},
            placeholder = {Text(text = "Please enter your email")},
            modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = password,
            onValueChange = {newPassword ->password = newPassword},
            label = {Text(text = "Enter Password")},
            placeholder = {Text(text = "Please enter your password")},
            modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {},
            modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(Color.Green)) {
            Text(text = "Login")


        }
        Text(text = buildAnnotatedString { append("Don't have an Account, Register here") },
            modifier = Modifier.wrapContentWidth()
                .align(Alignment.CenterHorizontally)
                .clickable{
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                })
    }
}
@Composable
fun AnimatedLogo() {
    val scale by animateFloatAsState(
        targetValue = 1.2f,
        animationSpec = tween(durationMillis = 1000)
    )
    Image(
        painter = painterResource(R.drawable.logo),
        contentDescription = "logo",
        modifier = Modifier
            .graphicsLayer(scaleX = scale, scaleY = scale)
            .height(200.dp)
            .fillMaxWidth()
            .padding(16.dp)
    )
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun loginScreenPreview(){
    LoginScreen()
}