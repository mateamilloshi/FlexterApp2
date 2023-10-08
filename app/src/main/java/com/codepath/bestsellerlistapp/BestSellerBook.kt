package com.codepath.bestsellerlistapp

import com.google.gson.annotations.SerializedName
import com.codepath.bestsellerlistapp.Person

/**
 * The Model for storing a single book from the NY Times API
 *data class Movie(
 *     val name: String,
 *     val title: String,
 *     val description: String,
 *     val posterUrl: String
 * )
 *
 * SerializedName tags MUST match the JSON response for the
 * object to correctly parse with the gson library.
 */
class Person {
    @SerializedName("name")//rank
    var name: String? = null

    @JvmField
    @SerializedName("title")//title
    var title: String? = null

    @JvmField
    @SerializedName("description")//author
    var description: String? = null

    //TODO ImageUrl
    @JvmField
    @SerializedName("posterUrl")//author
    var posterUrl: String? = null

    @JvmField
    @SerializedName("id")//author
    var id: String? = null

    @JvmField
    @SerializedName("profile_path")//author
    var profilePath: String? = null

    //TODO description


    //TODO-STRETCH-GOALS amazonUrl
}
