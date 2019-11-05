package com.futuremind.example

import com.futuremind.preferencesdelegates.PrefsDelegateJsonParser
import com.google.gson.Gson
import javax.inject.Inject

class GsonJsonParser @Inject constructor(val gson: Gson) {

    inline fun <reified T> fromJson(json: String): T = gson.fromJson(json, T::class.java)
    fun <T> toJson(value: T): String = gson.toJson(value)

    inline fun <reified T> prefsDelegateJsonParser() = PrefsDelegateJsonParser<T>(::fromJson, ::toJson)
}