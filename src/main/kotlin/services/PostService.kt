package dev.shinyepo.services

import dev.shinyepo.HttpClientManager
import dev.shinyepo.models.Post
import io.ktor.client.call.body
import io.ktor.client.request.get

class PostService() {

    suspend fun fetchAllPosts(): List<Post> {
        return try {
            HttpClientManager.Client.use { client ->
                client.get("https://jsonplaceholder.typicode.com/posts").body<List<Post>>()
            }
        } catch (e: Exception) {
            println("Encountered error while fetching posts: \n" + e.localizedMessage)
            emptyList()
        }
    }
}