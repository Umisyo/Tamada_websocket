package com.example.websocket_client

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URI

class MainActivity : AppCompatActivity() {

    private val uri = URI("ws://192.168.0.116:1234/")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        btnConnect.setOnClickListener{
            val client = MyWebSocket(this, uri)
            client.connect()
            it.isEnabled = false
        }
        }
    }
