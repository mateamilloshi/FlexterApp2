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
import com.codepath.bestsellerlistapp.Person
import com.codepath.bestsellerlistapp.R

class PeopleAdapter(
    private val people: List<Person>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<PeopleAdapter.PersonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item_layout, parent, false)
        return PersonViewHolder(view)
    }

    inner class PersonViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mPersonName: TextView = mView.findViewById(R.id.person_name)
        val mPersonProfile: ImageView = mView.findViewById(R.id.person_profile)


        fun bind(person: Person) {
            mPersonName.text = person.name

            Glide.with(itemView.context)
                .load(person.profilePath)
                .into(mPersonProfile)

            mView.setOnClickListener {
                mListener?.onItemClick(person)
            }
        }
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val movie = people[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return people.size
    }
}

class Glide {
    val gson = Gson()

}
