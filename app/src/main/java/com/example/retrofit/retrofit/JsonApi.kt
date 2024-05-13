package com.example.retrofit.retrofit

import com.example.retrofit.pojo.PostCommentResponse
import com.example.retrofit.pojo.PostResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query


// The Response keyword is basically used to check whether it is successfully able to fetch the data from api or not.
// and inside the response we type the type of response we are getting from it.

interface JsonApi {

    // for getting all posts            -->      GET	/posts
    @GET("posts")
    suspend fun getPosts() : Response<List<PostResponse>>

    // for getting single post using id  -->     GET	/posts/1
    @GET("posts/{id}")
    suspend fun getSinglePost(@Path("id") id : Int) :Response<PostResponse>

    // for getting particular post comments  --> GET	/posts/1/comments
    @GET("posts/{id}/comments")
    suspend fun getSinglePostComments(@Path("id") id : Int) : Response<List<PostCommentResponse>>

    /* for getting comments of particular post   --> GET	/comments?postId=1
       (similar to above one but in this statement but in this statement we are querying instead of directly using
       ? -> this is query symbol in a link
    */
    @GET("comments")
    suspend fun getCommentsByPostId(@Query("postId") id : Int) : Response<List<PostCommentResponse>>


    // annotate with @Body so that server will know this -> It's used to send data in the request body of the HTTP request
    @POST("posts")
    suspend fun postSingleDataToServer(@Body postResponse: PostResponse) : Response<PostResponse>


    // used to update the whole post so we pass which post to update and pass the updated post then get the updated response.
    @PUT("posts/{id}")
    suspend fun putPostRequest(@Path("id") id : Int ,@Body postResponse: PostResponse) : Response<PostResponse>


    // used to update some of the attributes of post
    @PATCH("posts/{id}")
    suspend fun patchPostRequest(@Path("id") id : Int ,@Body postResponse: PostResponse) : Response<PostResponse>


}