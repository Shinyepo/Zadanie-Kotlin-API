package dev.shinyepo.models

import kotlinx.serialization.Serializable

@Serializable
data class Post(val userId: Int, val id: Int, val title : String, val body: String)