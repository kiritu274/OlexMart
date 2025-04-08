package com.example.olex

import android.R.attr.value
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.olex.ui.theme.OlexTheme

class AddproductActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OlexTheme {
                AddproductScreen()
            }
        }
    }
}

@Composable
fun AddproductScreen(){
    val imageUri = rememberSaveable(){ mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri:Uri? ->uri?.let{imageUri.value=it} }
    var productname by remember { mutableStateOf(value = "") }
    var productquantity by remember { mutableStateOf(value = "") }
    var productprice by remember { mutableStateOf(value = "") }
    var desc by remember { mutableStateOf(value = "") }

    Column(modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "ADD NEW PRODUCT",

            fontSize = 30.sp,
            color = Color.White,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(30.dp)
                .fillMaxWidth()
                .background(color = Color.Black)

        )
        Card(shape = CircleShape,
            modifier = Modifier.padding(10.dp).size(200.dp)) {
            AsyncImage(model = imageUri.value ?:R.drawable.ic_person,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(200.dp)
                    .clickable{launcher.launch("image/*")})
        }
        Text(text = "Attach product image")
        OutlinedTextField(value = productname,
            onValueChange = {newProductname->productname=newProductname},
            label = {Text(text = "Product Name")},
            placeholder = {Text(text = "Please enter product name")},
            modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = productquantity,
            onValueChange = {newProductquantity->productquantity=newProductquantity},
            label = {Text(text = "Product Quantity")},
            placeholder = {Text(text ="Please enter product quantity" )},
            modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = productprice,
            onValueChange = {newProductprice->productprice=newProductprice},
            label = {Text(text = "Unit Product Price")},
            placeholder = {Text(text = "Please enter product price")},
            modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = desc,
            onValueChange = {newDes->desc=newDes},
            label = {Text(text = "Brief description")},
            placeholder = {Text(text = "Please enter product description")},
            modifier = Modifier.fillMaxWidth().height(150.dp),
            singleLine = false)
        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = {},) {Text(text = "HOME") }
            Button(onClick = {},
                colors = ButtonDefaults.buttonColors(Color.Green)) {
                Text(text = "SAVE")}


        }

    }

}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddproductScreenPreview(){
    AddproductScreen()
}