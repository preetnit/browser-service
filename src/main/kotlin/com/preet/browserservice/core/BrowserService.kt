package com.preet.browserservice.core;

interface BrowserService {
    fun start(userId: String, browserId: String, url: String)
    fun stop(userId: String, browserId: String)
    fun getURL(userId: String, browserId: String): String
    fun cleanup(userId: String, browserId: String)
}
