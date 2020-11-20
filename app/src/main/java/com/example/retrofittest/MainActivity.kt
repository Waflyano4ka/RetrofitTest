package com.example.retrofittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.retrofittest.models.urlImageModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            sendNetworkRequest()
        }
    }

    private fun sendNetworkRequest() {
        val builder = Retrofit.Builder()
            .baseUrl("https://aws.random.cat/")
            .addConverterFactory(GsonConverterFactory.create())
        val retrofit = builder.build()
        val apiInterface: ApiInterface = retrofit.create<ApiInterface>(ApiInterface::class.java)
        val call: retrofit2.Call<urlImageModel> = apiInterface.getFile()
        call.enqueue(object: Callback<urlImageModel>{
            override fun onFailure(call: Call<urlImageModel>, t: Throwable) {
                Log.i("Lol", t.message.toString())
            }
            override fun onResponse(call: Call<urlImageModel>, response: Response<urlImageModel>) {
                textView.text = response.body()!!.file
            }
        })

    }
}