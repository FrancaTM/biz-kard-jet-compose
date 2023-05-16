package com.example.bizkard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bizkard.ui.theme.BizKardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            BizKardTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                BizKardApp()
            }
        }
    }
}

@Composable
fun BizKardApp() {
    BizKardInfo()
}

@Composable
private fun BizKardInfo() {
    Column(
        modifier = Modifier
            .background(Color(211, 232, 213))
            .padding(10.dp)
    ) {
        PresentationSection(modifier = Modifier.weight(0.8F))
        ContactInfoSection(modifier = Modifier.weight(0.2F))
    }
}

@Composable
private fun PresentationSection(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        val imagePainter = painterResource(R.drawable.android_logo)
        Image(
            painter = imagePainter,
            contentDescription = null,
            Modifier
                .background(color = Color(10, 48, 65))
                .size(128.dp)
        )
        Text(
            text = "Jennifer Doe",
            fontSize = 52.sp,
            fontWeight = FontWeight.Light
        )
        Text(
            text = "Android Developer",
            fontSize = 20.sp,
            color = Color(48, 123, 81),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun ContactInfoSection(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxHeight()
                .padding(14.dp)
        ) {
            val myAppIcons = Icons.Filled
            ContactInfoLine(
                info = "+55 (41) 99876-5432",
                contentDescription = "Phone number",
                iconImage = myAppIcons.Phone
            )
            ContactInfoLine(
                info = "@AndroidDev",
                contentDescription = "Social",
                iconImage = myAppIcons.Share
            )
            ContactInfoLine(
                info = "jen.doe@android.com",
                contentDescription = "Email contact",
                iconImage = myAppIcons.Email
            )
        }
    }
}

@Composable
fun ContactInfoLine(info: String, contentDescription: String, iconImage: ImageVector) {
    Row {
        Icon(
            iconImage,
            contentDescription = contentDescription,
            tint = Color(12, 108, 61)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = info,
            color = Color(25, 40, 30)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BizKardAppPreview() {
    BizKardApp()
}