package com.plcoding.ktorclientandroid.data.remote

import com.plcoding.ktorclientandroid.data.remote.dto.PostRequest
import com.plcoding.ktorclientandroid.data.remote.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
//import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.logging.*
//import io.ktor.client.features.json.*
//import io.ktor.client.features.json.serializer.*
//import io.ktor.client.features.logging.*
import io.ktor.serialization.kotlinx.json.*


interface PostsService {

    suspend fun getPosts(): List<PostResponse>

    suspend fun createPost(postRequest: PostRequest): PostResponse?

    companion object {
        fun create(): PostsService {
            return PostsServiceImpl(
                client = HttpClient(Android) {
                    install(Logging) {
                        //logger = Logger.DEFAULT
                        level = LogLevel.ALL
                    }
                    install(ContentNegotiation) {
                        json()
                    }
//                    install(JsonFeature) {
//                        serializer = KotlinxSerializer()
//                    }
                }
            )
        }
    }
}