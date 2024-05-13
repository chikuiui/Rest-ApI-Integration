package com.example.retrofit

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.adapters.RecyclerAdapter
import com.example.retrofit.adapters.RecyclerAdapterComment
import com.example.retrofit.pojo.PostCommentResponse
import com.example.retrofit.pojo.PostResponse
import com.example.retrofit.retrofit.JsonApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    /*
      -> Retrofit
      -> Retrofit Converter (Gson)
     */



    private lateinit var singlePost : MutableLiveData<PostResponse>

    private lateinit var singlePostComments : MutableLiveData<List<PostCommentResponse>>

    private val retrofitService: JsonApi = RetrofitInstance.getRetrofitInstance().create(JsonApi::class.java)
    private lateinit var posts : MutableLiveData<List<PostResponse>>

    // for posting the data to server
    private val data = MutableLiveData<List<PostResponse>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        singlePost = MutableLiveData<PostResponse>()
        singlePostComments = MutableLiveData<List<PostCommentResponse>>()




        val recyclerView  = findViewById<RecyclerView>(R.id.recycler)

        posts = MutableLiveData<List<PostResponse>>()

        // get all posts

//        getData(retrofitService)
//        posts.observe(this) {
//            val adapter = RecyclerAdapter(it)
//            recyclerView.adapter = adapter
//        }

        // get single post

//        getSingleData(retrofitService)
//        singlePost.observe(this,{
//            val adapter = RecyclerAdapter(listOf(it))
//            recyclerView.adapter = adapter
//        })

        // get single post comments without query

//        getSinglePostComments(retrofitService)
//        singlePostComments.observe(this,{
//            val adapter = RecyclerAdapterComment(it)
//            recyclerView.adapter = adapter
//        })

        // get single post comments with query

//          getSinglePostCommentsUsingQuery(retrofitService)
//          singlePostComments.observe(this) {
//              val adapter = RecyclerAdapterComment(it)
//              recyclerView.adapter = adapter
//          }


         // POST a data into server
//         postDataToServer(retrofitService)
//         data.observe(this){
//             val adapter = RecyclerAdapter(it)
//             recyclerView.adapter = adapter
//         }

        // PUT -> TO completely update the PostResponse object present in api
//         putPostRequest(retrofitService)
//        data.observe(this){
//            val adapter = RecyclerAdapter(it)
//            recyclerView.adapter = adapter
//        }

        // PATCH -> to update some of the attributes in the PostResponse object present in api
         patchPostRequest(retrofitService)
         data.observe(this){
             val adapter = RecyclerAdapter(it)
             recyclerView.adapter = adapter
         }
    }

    // GET
    private fun getData(jsonApi : JsonApi){
        CoroutineScope(Dispatchers.IO).launch {
            val response = jsonApi.getPosts()
            if(response.isSuccessful){
                posts.postValue(response.body())
            }
        }
    }
    private fun getSingleData(jsonApi : JsonApi){
        CoroutineScope(Dispatchers.IO).launch {
            val response =jsonApi.getSinglePost(2)
            if(response.isSuccessful){
                singlePost.postValue(response.body())
            }
        }
    }
    private fun getSinglePostComments(jsonApi : JsonApi){
        CoroutineScope(Dispatchers.IO).launch {
            val response = jsonApi.getSinglePostComments(1)
            if(response.isSuccessful){
                singlePostComments.postValue(response.body())
            }
        }
    }
    private fun getSinglePostCommentsUsingQuery(jsonApi: JsonApi){
        CoroutineScope(Dispatchers.IO).launch {
            val response = jsonApi.getCommentsByPostId(1)
            if(response.isSuccessful){
                singlePostComments.postValue(response.body())
            }else{
                Log.e("TAG","ERROR")
            }
        }
    }

    // POST
    private fun postDataToServer(jsonApi: JsonApi){
         CoroutineScope(Dispatchers.IO).launch {
             val response  = jsonApi.postSingleDataToServer(PostResponse("hello world",254,"The End",3))
             if(response.isSuccessful){
                 response.body()?.let {
                     data.postValue(listOf(it))
                 }
             }
         }
    }

    // PUT
    private fun putPostRequest(jsonApi: JsonApi){
        CoroutineScope(Dispatchers.IO).launch {
            val response = jsonApi.putPostRequest(4, PostResponse("HEllo",4,"WORLD",6))
            if(response.isSuccessful){
                response.body()?.let {
                    data.postValue(listOf(it))
                }
            }
        }

    }

    // PATCH
    private fun patchPostRequest(jsonApi : JsonApi){
        CoroutineScope(Dispatchers.IO).launch {
            val response = jsonApi.patchPostRequest(4, PostResponse("HEllo",4,"WORLD",6))
            if(response.isSuccessful){
                response.body()?.let {
                    data.postValue(listOf(it))
                }
            }
        }
    }

}