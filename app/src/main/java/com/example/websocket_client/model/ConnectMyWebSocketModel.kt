package com.example.websocket_client.model

import com.example.websocket_client.accessor.MyWebSocket
import com.example.websocket_client.accessor.MyWebSocketEntity

class ConnectMyWebSocketModel
    : BaseModel<ConnectMyWebSocketModel.ConnectMyWebSocketListener>(ConnectMyWebSocketModel::class.java.simpleName)
        ,MyWebSocket.MyWebSocketListener {

    interface ConnectMyWebSocketListener {
        fun onMessage(message: String?)
    }

    private val myWebSocket = MyWebSocket

    init {
        myWebSocket.setListener(this, this)
    }

    fun connect() {
        if (myWebSocket.isOpen) return

        myWebSocket.connect()
    }

    override fun onMessage(entity: MyWebSocketEntity) {
        listenerMap.forEach { it.value.onMessage(entity.message) }
    }
}