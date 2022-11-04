package com.example.moviestack

import android.annotation.SuppressLint
import android.app.ActionBar
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MovieInfoActivity : AppCompatActivity() {

    var idImage: Long = 0
    var movieName: String = ""
    var movieDescription: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_info)

        Log.i("context", "$applicationContext")
        idImage = intent.getLongExtra("ID_IMG", idImage)
        movieName = intent.getStringExtra("MOVIE_NAME").toString()
        movieDescription = intent.getStringExtra("MOVIE_DESCRIPTION").toString()
        updateMovieName()
    }

    @SuppressLint("CutPasteId")
    fun updateMovieName(){
        if(idImage == 0L){
            val uriImage = Uri.parse("android.resource://" + packageName + "/" + R.drawable.chandler)
            val imageView = findViewById<ImageView>(R.id.movieImage)
            imageView.setImageURI(uriImage)
        }else if(idImage == 1L){
            val uriImage = Uri.parse("android.resource://" + packageName + "/" + R.drawable.ross)
            val imageView = findViewById<ImageView>(R.id.movieImage)
            imageView.setImageURI(uriImage)
        }else if(idImage == 2L){
            val uriImage = Uri.parse("android.resource://" + packageName + "/" + R.drawable.phoebe)
            val imageView = findViewById<ImageView>(R.id.movieImage)
            imageView.setImageURI(uriImage)
        }else if(idImage == 3L){
            val uriImage = Uri.parse("android.resource://" + packageName + "/" + R.drawable.monica)
            val imageView = findViewById<ImageView>(R.id.movieImage)
            imageView.setImageURI(uriImage)
        }else if(idImage == 4L){
            val uriImage = Uri.parse("android.resource://" + packageName + "/" + R.drawable.joey)
            val imageView = findViewById<ImageView>(R.id.movieImage)
            imageView.setImageURI(uriImage)
        }else if(idImage == 5L){
            val uriImage = Uri.parse("android.resource://" + packageName + "/" + R.drawable.rachel)
            val imageView = findViewById<ImageView>(R.id.movieImage)
            imageView.setImageURI(uriImage)
        }
        findViewById<TextView>(R.id.movieName).text = movieName
        findViewById<TextView>(R.id.movieDescription).text = movieDescription

        val txt = findViewById<TextView>(R.id.movieDescription)
        txt.setTextSize(TypedValue.COMPLEX_UNIT_SP,14F)
    }
}