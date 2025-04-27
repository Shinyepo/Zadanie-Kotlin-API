package dev.shinyepo.services

import dev.shinyepo.network.HttpClientManager
import dev.shinyepo.models.Post
import dev.shinyepo.network.ApiOperation
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.slf4j.LoggerFactory

class PostService() {
    private val logger = LoggerFactory.getLogger(this::class.java)

    suspend fun fetchAllPosts(): ApiOperation<List<Post>> {
        return HttpClientManager.safeApiCall {
            logger.info("Fetching all posts...")
            HttpClientManager.client.use { client ->
                client.get("https://jsonplaceholder.typicode.com/posts").body<List<Post>>()
            }
        }
    }
}