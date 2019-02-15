package com.example.websocket_client

import android.app.Activity
import android.widget.TextView
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.net.URI
import android.util.Log
import java.lang.Exception

class  MyWebSocket(val activity: Activity, uri: URI) : WebSocketClient(uri){
    override fun onError(ex: Exception?) {
        Log.i(javaClass.simpleName, "error")
        Log.i(javaClass.simpleName, "loading in ${Thread.currentThread().name}")
    }

    private val contentView: TextView by lazy{
        activity.findViewById<TextView>(R.id.messageList)
    }

    private val breakLine = System.lineSeparator()

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
        activity.runOnUiThread{
            contentView.append("$message")
            contentView.append("$breakLine")
            Log.i(javaClass.simpleName, "write message in TextView")
            Log.i(javaClass.simpleName, "loading in ${Thread.currentThread().name}")
        }
    }
}