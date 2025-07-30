package com.example.rickandmorty.util

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun ImageFromUrl(imageUrl: String) {
    AsyncImage(
        model = imageUrl,
        contentDescription = "Image from api",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}