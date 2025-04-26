package dev.shinyepo.utils

import dev.shinyepo.models.Post
import kotlinx.serialization.json.Json
import java.io.File

object FileUtils {
    private val readableJson: Json = Json { prettyPrint = true }

    fun savePostToFile(post: Post) {
        val formattedString = readableJson.encodeToString(post)

        val dir = File("posts")
        if (!dir.exists()) {
            dir.mkdir()
        }

        val file = File(dir, "${post.id}.json")
        if (file.exists()) {
            println("File with post id ${post.id} already exists. Skipping...")
            return
        }
        file.writeText(formattedString)
    }
}