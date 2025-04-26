package dev.shinyepo

import dev.shinyepo.services.PostService
import dev.shinyepo.utils.FileUtils

suspend fun main() {

    println("Fetching posts...")
    val posts = PostService().fetchAllPosts()
    println("Fetched ${posts.size} posts.")

    if (posts.isNotEmpty()) {
        println("Saving posts to ~/posts/<post_id>.json")
        for (post in posts) {
            FileUtils.savePostToFile(post)
        }
        println("Done.")
    }

}