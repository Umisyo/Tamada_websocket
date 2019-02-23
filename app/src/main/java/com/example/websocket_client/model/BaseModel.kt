package com.example.websocket_client.model

import com.example.websocket_client.view.activity.BaseActivity

abstract class BaseModel<T> (val tag: String) {

    var listenerMap: MutableMap<String, T> = mutableMapOf()

    fun setListener (activity: BaseActivity, listener: T) {
        listenerMap[activity.tag] = listener
    }

    fun dropListener (activity: BaseActivity) {
        listenerMap.remove(activity.tag)
    }
}