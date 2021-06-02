package com.mlp.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mlp.project.api.ApiClient
import com.mlp.project.api.SessionManager
import com.mlp.project.api.model.LoginRequest
import com.mlp.project.api.model.LoginResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener(){
/*
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if(email.isEmpty()){
                editTextEmail.error = "Email required"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }


            if(password.isEmpty()){
                editTextPassword.error = "Password required"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }
*/
            val email: String = "sbanks@wwe.net"
            val password: String = "12345678"
            login(email, password)
        }
    }

    private fun login(email: String, password: String) {
        apiClient = ApiClient()
        sessionManager = SessionManager(this)

        val login = LoginRequest(email, password)

        apiClient.getApiService().login(login)
            .enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    // Error logging in
                }

                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    println(response)

                    if (response.isSuccessful) {
                        val loginResponse = response.body()
                        sessionManager.saveAuthToken(loginResponse!!.token)
                        isAuth()

                    } else {
                        println("BIG FAILURE")
                    }

                }
            })
    }

    private fun isAuth(){
        val intent = Intent(this@MainActivity, Authenticated::class.java)
        startActivity(intent)
    }
}
