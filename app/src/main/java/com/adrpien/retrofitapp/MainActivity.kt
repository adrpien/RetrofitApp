package com.adrpien.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrpien.retrofitapp.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import kotlin.random.Random

/*

Picasso
Picasso allows for hassle-free image loading in your application—often in one line of code!
_____________________________________________________________________
Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(imageView);
_____________________________________________________________________
Many common pitfalls of image loading on Android are handled automatically by Picasso:
Handling ImageView recycling and download cancelation in an adapter.
Complex image transformations with minimal memory use.
Automatic memory and disk caching.

Retrofit - A type-safe HTTP client for Android and Java,
Retrofit turns your HTTP API into a Java interface.

OkHttp is a third-party library for sending and receive HTTP-based network requests.
OkHttp library actually provides an implementation of the HttpUrlConnection interface.

How to:
1. Add dependecies
2. Create Data class using "Kotlin data class from JSON" Tool
3. Create RetrofitClient
4. Create interface for HTTPClient
5. Add onClickListener
   - download photos using Retrofit Client in Coroutine
   - add photos to ArrayList
   - load photo using Picasso
6. Add permission in manifest file

 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val urlList = ArrayList<String>()

        CoroutineScope(Dispatchers.IO).launch {
            RetrofitClient.instance.getPhotosAsync()
                .await()
                .body()!!.forEach { urlList.add((it.download_url)) }
        }

        binding.picsumImageView.setOnClickListener {

            Picasso.get().load(urlList[Random.nextInt(urlList.size-1)]).into(binding.picsumImageView)

        }
    }
}