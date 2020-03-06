package io.github.dimi1991.schulprojekt.Controller

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL

class ApiRequestor(private var baseUrl: String) {

    public fun getDevices(): String {
        return request("$baseUrl/devices.php")
    }

    private fun request(requestUrl: String): String {
        return URL(requestUrl).readText()
    }
}