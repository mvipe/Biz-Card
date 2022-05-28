package com.learn.bizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learn.bizcard.ui.theme.BizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    createBizCard()
                }
            }
        }
    }
}

@Composable
fun createBizCard(){
    Surface( modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(20.dp)
            , shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            backgroundColor = Color.White
            , elevation = 4.dp) {
                Column(modifier = Modifier.height(300.dp),
                    verticalArrangement = Arrangement.Top
                    , horizontalAlignment = Alignment.CenterHorizontally)
                    {


                        CreateImageProfile()
                        Divider(color = Color.Red)

                        CreateInfo()
                        
                        Button(onClick = {  }) {
                            Text(text = "Portfolio",
                            style = MaterialTheme.typography.button)
                        }
                }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Content(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)){
        Surface(modifier = Modifier.padding(3.dp).
        fillMaxWidth().fillMaxHeight(), shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        border = BorderStroke(width=2.dp, color = Color.Gray)) {
            Portfolio(data= listOf("Project 1","Project 2","Project 3","Project 4"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    Text("All Projects ")
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Miles P",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant
        )

        Text(
            text = "Android Developer", modifier = Modifier.padding(3.dp)
        )
    }
}


@Composable
private fun CreateImageProfile() {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp), shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.user),
            contentDescription = "Profile Image",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}


@Composable
fun DefaultPreview() {
    BizCardTheme {
        createBizCard()
    }
}