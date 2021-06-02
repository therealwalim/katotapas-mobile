package com.mlp.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import com.mlp.project.api.ApiClient
import com.mlp.project.api.SessionManager
import com.mlp.project.api.model.ProductResponse
import com.mlp.project.utils.MyAdapter
import kotlinx.android.synthetic.main.activity_authenticated.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Authenticated : AppCompatActivity() {

    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient

    lateinit var myadapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authenticated)

        recyprod.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyprod.layoutManager = linearLayoutManager

        myadapter = MyAdapter(baseContext)
        recyprod.adapter = myadapter

        fetchPosts()
    }

    private fun fetchPosts() {
        // val count: Number

        apiClient = ApiClient()
        sessionManager = SessionManager(this)

        // Pass the token as parameter
        //println("${sessionManager.fetchAuthToken()}")

        apiClient.getApiService().fetchPosts(token = "${sessionManager.fetchAuthToken()}")
            .enqueue(object : Callback<ProductResponse> {
                override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                    d("Authenticated", "onFailure" + t.message)
                }

                override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
                    Log.d("Response", response.toString())

                    val responseBody = response.body()

                    myadapter.setProductList(responseBody!!.products)
                    myadapter.notifyDataSetChanged()
                }
            })
    }
}
