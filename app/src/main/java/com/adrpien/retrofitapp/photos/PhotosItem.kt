package com.adrpien.retrofitapp.photos

data class PhotosItem(
    val author: String,
    val download_url: String,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)