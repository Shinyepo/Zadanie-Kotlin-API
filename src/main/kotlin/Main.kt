package dev.shinyepo

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.runBlocking


fun main() {
    val client = HttpClient(CIO)

    runBlocking {
        val request: HttpResponse = client.get("https://jsonplaceholder.typicode.com/posts")

        println(request.status)
    }
}