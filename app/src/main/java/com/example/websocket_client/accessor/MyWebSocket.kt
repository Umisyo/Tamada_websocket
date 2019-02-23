package com.example.websocket_client.accessor

import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.net.URI
import android.util.Log
import com.example.websocket_client.model.BaseModel
import java.lang.Exception

object MyWebSocket : WebSocketClient(URI("ws://192.168.0.116:1234/")){

    interface MyWebSocketListener {
        fun onMessage(entity: MyWebSocketEntity)
    }

    private val listenerMap : MutableMap<String, MyWebSocketListener> = mutableMapOf()

    fun setListener (model: BaseModel<*>, listener: MyWebSocketListener) {
        listenerMap[model.tag] = listener
    }

    fun dropListener (model: BaseModel<*>) {
        listenerMap.remove(model.tag)
    }

    override fun onError(ex: Exception?) {
        Log.i(javaClass.simpleName, "error")
        Log.i(javaClass.simpleName, "loading in ${Thread.currentThread().name}")
    }

    override fun onOpen(handshakedata: ServerHandshake?) {
        Log.i(javaClass.simpleName, "connected by WS  server")
        Log.i(javaClass.simpleName, "loading in ${Thread.currentThread().name}")
    }

    override fun onClose(code: Int, reason: String?, remote: Boolean) {
        Log.i(javaClass.simpleName, "disconnected by WS server")
        Log.i(javaClass.simpleName, "loading in ${Thread.currentThread().name}")
    }

    override fun onMessage(message: String?) {
        Log.i(javaClass.simpleName, "received massage")
        Log.i(javaClass.simpleName, "loading in ${Thread.currentThread().name}")
        listenerMap.forEach { it.value.onMessage(MyWebSocketEntity(message = message)) }
    }

}

data class MyWebSocketEntity (val message: String?)