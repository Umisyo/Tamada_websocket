package com.example.websocket_client

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URI

class MainActivity : AppCompatActivity() {

    private val uri = URI("ws://192.168.43.110:1234/")
    private val client = MyWebSocket(this, uri)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        btnConnect.setOnClickListener{
            client.connect()
            it.isEnabled = false
            btnDisConnect.isEnabled = true
        }
        btnDisConnect.setOnClickListener{
            client.close()
            it.isEnabled = false
            btnConnect.isEnabled = true
        }
    }
}
