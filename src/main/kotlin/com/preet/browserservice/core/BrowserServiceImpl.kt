package com.preet.browserservice.core

import org.springframework.stereotype.Service
import java.util.Locale

@Service
class BrowserServiceImpl : BrowserService {
    override fun start(userId: String, browserId: String, url: String) {
        val os = System.getProperty("os.name").lowercase(Locale.getDefault())
        val rt = Runtime.getRuntime()

        try {
            if (os.indexOf("win") >= 0) {
                rt.exec("rundll32 url.dll,FileProtocolHandler $url")
            } else if (os.indexOf("mac") >= 0) {
                var browser = ""
                if(browserId.contains("firefox"))
                    browser = "-a Firefox.app"
                rt.exec("open $url $browser")
            } else if (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0) {

                // Do a best guess on unix until we get a platform independent way
                // Build a list of browsers to try, in this order.
                val browsers = arrayOf(
                    "epiphany", "firefox", "mozilla", "konqueror",
                    "netscape", "opera", "links", "lynx"
                )

                // Build a command string which looks like "browser1 "url" || browser2 "url" ||..."
                val cmd = StringBuffer()
                for (i in browsers.indices) cmd.append((if (i == 0) "" else " || ") + browsers[i] + " \"" + url + "\" ")
                rt.exec(arrayOf("sh", "-c", cmd.toString()))
            } else {
                return
            }
        } catch (e: Exception) {
            return
        }
        return
    }

    override fun stop(userId: String, browserId: String) {
        //val os = System.getProperty("os.name").lowercase(Locale.getDefault())
        val rt = Runtime.getRuntime()

        try {
            if(browserId.contains("chrome")) {
                val cmds = arrayOf("killall", "Google Chrome")
                rt.exec(cmds)
            }else if(browserId.contains("firefox")) {
                rt.exec("pkill -f firefox")
            }
        }catch (e: Exception) {
            print(e)
        }

        return
    }

    override fun getURL(userId: String, browserId: String): String {
        TODO("Not yet implemented")
    }

    override fun cleanup(userId: String, browserId: String) {
        TODO("Not yet implemented")
    }

}