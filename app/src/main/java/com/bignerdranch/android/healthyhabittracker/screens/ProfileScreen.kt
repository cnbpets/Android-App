package com.bignerdranch.android.healthyhabittracker.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import androidx.compose.runtime.*

@Composable
fun ProfileScreen() {

    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val launcher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) { uri ->

            imageUri = uri
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (imageUri != null) {

            Image(
                painter = rememberAsyncImagePainter(imageUri),
                contentDescription = "Profile Picture",

                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape),

                contentScale = ContentScale.Crop
            )
        }

        Button(
            onClick = {
                launcher.launch("image/*")
            }
        ) {
            Text("Choose Profile Picture")
        }
        Text(
            text = "Profile",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Healthy Habit Tracker",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text("Habits Tracked: 4")
                Text("Current Streak: 5 Days")
                Text("Weekly Goal: Stay Consistent")
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Database Status: Room database integration in progress."
        )

        Text(
            text = "Built using Kotlin and Jetpack Compose",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}