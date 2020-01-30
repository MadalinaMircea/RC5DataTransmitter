package com.example.cryptosharingsystem

import okhttp3.*
import Information
import android.util.Log
import java.io.IOException
import okhttp3.MultipartBody
import okhttp3.RequestBody



class ServerCommunication {
    internal var client = OkHttpClient()
    val JSON = MediaType.parse("application/json; charset=utf-8")

    @Throws(IOException::class)
    internal fun post(url: String, info: Information): Response {
        var json = info.GetJson()
        Log.i("SERVER","Post to server, url " + url + ", body " + json)
        val body = RequestBody.create(JSON, json)
        val request = Request.Builder()
            .url(url)
            .post(body)
            .build()
        return client.newCall(request).execute()//.use { response -> return ServerResponse(response.body()!!.string(), response.code()) }
        //client.newCall(request).execute().use { response -> return response.body()!! }

//        val requestBody = MultipartBody.Builder()
//            .setType(MultipartBody.FORM)
//            .addFormDataPart("path", info.path)
//            .addFormDataPart("contents", info.contents)
//            .build()
//
//        val request = Request.Builder()
//            .url(url)
//            .post(requestBody)
//            .build()
//
//        return client.newCall(request).execute()
    }




//    @Throws(IOException::class)
//    internal fun get(url: String): Response {
//        Log.i("SERVER","Get from server, url " + url)
//        val request = Request.Builder()
//            .url(url)
//            .build()
//
//        return client.newCall(request).execute()!!//.use { response -> return ServerResponse(response.body()!!.string(), response.code()) }
//        //client.newCall(request).execute().use { response -> return response }
//    }
}