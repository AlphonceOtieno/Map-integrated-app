package com.example.mycomplexapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class WEbsiteActivity : AppCompatActivity() {
    lateinit var MyWebView:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_website)
        MyWebView =findViewById(R.id.MywebView)
        val webSettings = MyWebView.settings
        webSettings.javaScriptEnabled = true
        MyWebView.loadUrl("https://www.emobilis.ac.ke")
    }
}