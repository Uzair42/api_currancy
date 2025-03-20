package com.mu42.vidcryptocurrancylist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.mu42.vidcryptocurrancylist.databinding.HomePageBinding
import com.mu42.vidcryptocurrancylist.ui.theme.model
import com.mu42.vidcryptocurrancylist.ui.theme.rvAdapter

class MainActivity : AppCompatActivity() {

    lateinit var myBinding: HomePageBinding
    lateinit var rvAdapter: rvAdapter
    lateinit var data: ArrayList<model>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        myBinding = HomePageBinding.inflate(layoutInflater)

        setContentView(myBinding.root)

        data = ArrayList()
        rvAdapter = rvAdapter(this, data)


        myBinding.rvContainer.layoutManager = LinearLayoutManager(this)
        myBinding.rvContainer.adapter = rvAdapter


    }


    val apiData: Unit
        get() {
            val url = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/trending/latest"

            val volleyQueue = Volley.newRequestQueue(this)

            val jsonObjectReq: JsonObjectRequest =
                object : JsonObjectRequest(Method.GET, url, null,


                    Response.Listener {


                    },


                    Response.ErrorListener {
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    })

                {
                    override fun getHeaders(): MutableMap<String, String> {
                        return super.getHeaders()
                    }
                }


    }
}
