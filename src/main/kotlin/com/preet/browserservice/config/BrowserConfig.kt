package com.preet.browserservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "browsers.conf")
class BrowserConfig {

    lateinit var chrome: String
    lateinit var firefox: String
}