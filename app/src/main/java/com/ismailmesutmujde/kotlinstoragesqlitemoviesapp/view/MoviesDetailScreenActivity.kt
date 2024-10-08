package com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.databinding.ActivityMoviesDetailScreenBinding
import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.model.Movies

class MoviesDetailScreenActivity : AppCompatActivity() {

    private lateinit var bindingMoviesDetail : ActivityMoviesDetailScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMoviesDetail = ActivityMoviesDetailScreenBinding.inflate(layoutInflater)
        val view = bindingMoviesDetail.root
        setContentView(view)

        val movie = intent.getSerializableExtra("movieObject") as Movies

        bindingMoviesDetail.textViewMovieNameDetail.text = movie.movie_name
        bindingMoviesDetail.textViewMovieYearDetail.text = (movie.movie_year).toString()
        bindingMoviesDetail.textViewMovieDirectorDetail.text = movie.director.director_name
        bindingMoviesDetail.imageViewMoviePoster.setImageResource(resources.getIdentifier(movie.movie_poster,"drawable",packageName))
    }
}