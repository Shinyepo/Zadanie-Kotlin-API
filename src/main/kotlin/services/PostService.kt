package dev.shinyepo.services

import dev.shinyepo.HttpClientManager
import dev.shinyepo.models.Post
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.slf4j.LoggerFactory

class PostService() {
    private val logger = LoggerFactory.getLogger(this::class.java)

    suspend fun fetchAllPosts(): List<Post> {
        return try {
            logger.info("Fetching all posts...")
            HttpClientManager.client.use { client ->
                client.get("https://jsonplaceholder.typicode.com/posts").body<List<Post>>()
            }
        } catch (e: Exception) {
            logger.error("Encountered error while fetching posts: \n" + e.localizedMessage)
            emptyList()
        }
    }
}