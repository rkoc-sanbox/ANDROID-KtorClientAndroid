package com.plcoding.ktorclientandroid.data.remote

import com.plcoding.ktorclientandroid.data.remote.dto.PostRequest
import com.plcoding.ktorclientandroid.data.remote.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.call.*
//import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readBytes
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostsServiceImpl(
    private val client: HttpClient
) : PostsService {

    override suspend fun getPosts(): ByteArray {
        //val byteArray = withContext(Dispatchers.IO) {
//            client.get("").readBytes()
        //}
//    }
        val resp: HttpResponse = client.get("https://translate.google.com.vn/translate_tts?ie=UTF-8&q=Translated&tl=en&client=tw-ob")
        if (resp.status.value in 200..299) {
            println("Successful response!")
        }

        return resp.readBytes()

        //emptyList()

//        return try {
//            client.get { url(HttpRoutes.POSTS) }
//        } catch(e: RedirectResponseException) {
//            // 3xx - responses
//            println("Error: ${e.response.status.description}")
//            emptyList()
//        } catch(e: ClientRequestException) {
//            // 4xx - responses
//            println("Error: ${e.response.status.description}")
//            emptyList()
//        } catch(e: ServerResponseException) {
//            // 5xx - responses
//            println("Error: ${e.response.status.description}")
//            emptyList()
//        } catch(e: Exception) {
//            println("Error: ${e.message}")
//            emptyList()
//        }
    }

    override suspend fun createPost(postRequest: PostRequest): PostResponse? {
        return PostResponse(
            body = "",
            id = 0,
            title = "",
            userId = 0,
        )
    }
//        return try {
//            client.post<PostResponse> {
//                url(HttpRoutes.POSTS)
//                contentType(ContentType.Application.Json)
//                body = postRequest
//            }
//        } catch(e: RedirectResponseException) {
//            // 3xx - responses
//            println("Error: ${e.response.status.description}")
//            null
//        } catch(e: ClientRequestException) {
//            // 4xx - responses
//            println("Error: ${e.response.status.description}")
//            null
//        } catch(e: ServerResponseException) {
//            // 5xx - responses
//            println("Error: ${e.response.status.description}")
//            null
//        } catch(e: Exception) {
//            println("Error: ${e.message}")
//            null
//        }
//    }
}