package dev.shinyepo

import dev.shinyepo.services.PostService
import dev.shinyepo.utils.FileUtils
import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger("dev.shinyepo.main")

suspend fun main() {

    val posts = PostService().fetchAllPosts()
    logger.info("Fetched ${posts.size} posts.")

    if (posts.isNotEmpty()) {
        logger.info("Saving posts to ~/posts/<post_id>.json")
        for (post in posts) {
            FileUtils.savePostToFile(post)
        }
        logger.info("Done.")
    }

}