package com.example.websocket_client.view.activity

import android.os.Bundle
import com.example.websocket_client.R
import com.example.websocket_client.model.ConnectMyWebSocketModel
import com.example.websocket_client.model.ModelRepository.Companion.connectMyWebSocketModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity
    : BaseActivity(MainActivity::class.java.simpleName)
        , ConnectMyWebSocketModel.ConnectMyWebSocketListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectMyWebSocketModel.setListener(this, this)
    }

    override fun onResume() {
        super.onResume()

        btnConnect.setOnClickListener{
            connectMyWebSocketModel.connect()
            it.isEnabled = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        connectMyWebSocketModel.dropListener(this)
    }

    override fun onMessage(message: String?) {
        messageList.text = message ?: "not message"
    }
}
