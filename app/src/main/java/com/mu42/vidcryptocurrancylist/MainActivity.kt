package com.mu42.vidcryptocurrancylist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.mu42.vidcryptocurrancylist.databinding.HomePageBinding

class MainActivity : AppCompatActivity() {

    lateinit var myBinding: HomePageBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        myBinding= HomePageBinding.inflate(layoutInflater)

        setContentView(myBinding.root)


    }
}
