package dev.shinyepo

import dev.shinyepo.services.PostService
import dev.shinyepo.utils.FileUtils
import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger("dev.shinyepo.main")

suspend fun main() {
    PostService()
        .fetchAllPosts()
        .onSuccess { posts ->
            logger.info("Fetched ${posts.size} posts.")
            logger.info("Saving posts to ~/posts/<post_id>.json")

            for (post in posts) {
                FileUtils.savePostToFile(post)
            }

            logger.info("Done.")
        }
        .onFailure { exception ->
            logger.error(exception.localizedMessage)
        }
}