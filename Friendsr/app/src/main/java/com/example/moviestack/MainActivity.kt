package com.example.moviestack

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    private val moviesNames = arrayListOf<MoviesNames>(
        MoviesNames("Chandler", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
        MoviesNames("Ross", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
        MoviesNames("Phoebe", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
        MoviesNames("Monica", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
        MoviesNames("Joey", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
        MoviesNames("Rachel", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
      )
    override fun onCreate(savedInstanceState: Bundle?) {
        //setTheme(R.style.Theme_MovieStack)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hideImg()

        val listView = findViewById<ListView>(R.id.listView)
        val adapter = MoviesAdapter(this, R.layout.activity_movie_info, moviesNames)

        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, id ->
            selectMovies(id, moviesNames[position].name, moviesNames[position].description)
            adapter.notifyDataSetChanged()
        }
    }

    fun hideImg(){
        try{
            val img = findViewById<ImageView>(R.id.movieImage)
            img.visibility = View.GONE
        }catch(ex: Exception){
            Log.e("hideIMG", "$ex")
        }
    }

    fun selectMovies(id: Long, movieName: String, movieDescription: String) {
        // open a second activity
        val goto = Intent(this, MovieInfoActivity::class.java)
        Log.i("Id","$id")
        goto.putExtra("ID_IMG", id)
        goto.putExtra("MOVIE_NAME", movieName)
        goto.putExtra("MOVIE_DESCRIPTION", movieDescription)
        startActivity(goto)
    }
}