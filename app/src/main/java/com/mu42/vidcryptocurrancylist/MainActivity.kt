package com.mu42.vidcryptocurrancylist

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.RequestQueue
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

        apiData


        data = ArrayList<model>()

//        data.add(model("uzair","34.53","btc"))

        rvAdapter = rvAdapter(this, data)


        myBinding.rvContainer.layoutManager = LinearLayoutManager(this)
        myBinding.rvContainer.adapter = rvAdapter


    }


    val apiData: Unit
        get() {
//           ---------------------------------------------------------------------------
            val apikey=""
            val url = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest"

            val volleyQueue = Volley.newRequestQueue(this)

            val jsonObjectReq: JsonObjectRequest =
                object : JsonObjectRequest(Method.GET, url, null,


                    Response.Listener { response ->
                         try {
                            val dataArray = response.getJSONArray("data")
Toast.makeText(this,"Loading data ---", Toast.LENGTH_LONG).show()

                            for(i in 0 until   dataArray.length())
                            {
                                val dataObj=dataArray.getJSONObject(i)
                                val QUOTEobj=dataObj.getJSONObject("quote")
                                val usdObj=QUOTEobj.getJSONObject("USD")


                                val name=dataObj.getString("name")
                                val price:String =String.format("$"+"%.2f",usdObj.getDouble("price"));                           val symbol=dataObj.getString("symbol")


//                                Log.d("data",name.toString())
//                                Log.d("data",price.toString())
//                                Log.d("data",symbol.toString())

                                val tempModel=model(name,price,symbol)

//                                Log.d("data after",tempModel.cName.toString())
//                                Log.d("data after",tempModel.cPrice.toString())
//                                Log.d("data after",tempModel.cSymbol.toString())

                                data.add(tempModel)
//                                Log.d("data",dataArray.toString())

                            }
                            //notifyChanged??
                            rvAdapter.notifyDataSetChanged()
                            myBinding.progreebasr.isVisible=false

                        }
                        catch (e:Exception)
                        {
                            Log.i("exception"," ${e.message.toString()}")
                        }


                    },


                    Response.ErrorListener {
                        Log.e("error listener ", "error listener ka error"+it.toString() )
                        Toast.makeText(this, "Error in listener object", Toast.LENGTH_SHORT).show()
                    })

                {
                    override fun getHeaders(): MutableMap<String, String> {
                        val headers: MutableMap<String, String> = HashMap()
                        headers["X-CMC_PRO_API_KEY"] = apikey
                        return headers
                    }
                }





            volleyQueue.add(jsonObjectReq)
    }
}
