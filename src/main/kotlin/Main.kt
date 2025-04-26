package dev.shinyepo

import dev.shinyepo.services.PostService

suspend fun main() {
    val posts = PostService().fetchAllPosts()
}