package com.futuremind.example

import com.futuremind.preferencesdelegates.PrefsDelegateJsonParser
import com.squareup.moshi.Moshi
import javax.inject.Inject

class MoshiJsonParser @Inject constructor(val moshi: Moshi) {

    inline fun <reified T> fromJson(json: String): T = moshi.adapter<Any>(T::class.java).fromJson(json)!! as T
    inline fun <reified T> toJson(value: T): String = moshi.adapter<T>(T::class.java).toJson(value)

    inline fun <reified T> prefsDelegateJsonParser() = PrefsDelegateJsonParser<T>(::fromJson, ::toJson)
}