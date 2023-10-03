package com.codepath.bestsellerlistapp
import com.squareup.picasso.Picasso
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codepath.bestsellerlistapp.R.id
import com.google.gson.Gson

class MovieAdapter(
    private val movies: List<Movie>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item_layout, parent, false)
        return MovieViewHolder(view)
    }

    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mItem: Movie? = null
        val mMovieName: TextView = mView.findViewById(R.id.movie_name)
        val mMovieTitle: TextView = mView.findViewById(R.id.movie_title)
        val mMovieDescription: TextView = mView.findViewById(R.id.movie_description)
        val mMoviePoster: ImageView = mView.findViewById(R.id.movie_poster)

        fun bind(movie: Movie) {
            mMovieName.text = movie.name.toString()
            mMovieTitle.text = movie.title
            mMovieDescription.text = movie.description
            mMovieTitle.visibility = View.GONE
            Glide.with(itemView.context)
                .load(movie.posterUrl)
                .into(mMoviePoster)

            mView.setOnClickListener {
                mListener?.onItemClick(movie)
            }
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}

class Glide {
    val gson = Gson()

}
