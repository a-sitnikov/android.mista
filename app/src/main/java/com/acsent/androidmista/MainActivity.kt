package com.acsent.androidmista

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.NetworkInfo

import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}