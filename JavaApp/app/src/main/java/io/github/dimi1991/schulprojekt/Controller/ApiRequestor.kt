package io.github.dimi1991.schulprojekt.Controller

import java.net.URL

class ApiRequestor(var baseUrl: String, var UserId: String) {

    public fun getDevices(userId: Int): String {
        return request("$baseUrl?userId=$UserId")
    }

    private fun request(requestUrl: String): String{
        return URL(requestUrl).readText()
    }
}