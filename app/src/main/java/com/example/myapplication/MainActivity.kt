package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   lateinit var navController: NavController
   private lateinit var bindingMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)

        initUI()
    }

    private fun initUI() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        MAIN = this
    }
}