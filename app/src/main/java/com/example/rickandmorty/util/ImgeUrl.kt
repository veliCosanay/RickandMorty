package com.example.rickandmorty.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

@Composable
fun ImageFromUrl(imageUrl: String) {
    AsyncImage(
        model = imageUrl,
        contentDescription = "Image from api",
    )
}