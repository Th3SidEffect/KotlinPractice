package com.example.composepractice

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MonotonicFrameClock
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LikePost(modifier: Modifier) {

    var liked by remember { mutableStateOf(R.drawable.baseline_favorite_border_24) }
    var likeCount by remember { mutableStateOf(0) }
    var isliked by remember { mutableStateOf(false) }

    Card(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(R.drawable.post), contentDescription = "POST")
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = "Your motivation for today!")
            Button(
                {
                    if(isliked) {
                        likeCount--
                        liked = R.drawable.baseline_favorite_border_24
                        isliked = false
                    }
                    else{
                        likeCount++
                        liked = R.drawable.baseline_favorite_24
                        isliked = true
                    }
                }
            ) {
                Icon(painter = painterResource(liked), contentDescription = "")
            }
            Text(text = "$likeCount likes")
        }
    }
}