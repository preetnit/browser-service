package com.preet.browserservice.controller;

import com.preet.browserservice.core.BrowserService
import com.preet.browserservice.utils.API_VERSION
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(value = ["/v1/users/{userId}/browsers/{browserId}"])
class BrowserController{
    @Autowired
    lateinit var browserService: BrowserService

    @GetMapping("/start")
    @Operation(summary = "Start the desired browser and open the URL")
    fun getBrowser(
        @PathVariable("userId") userId: String,
        @PathVariable("browserId") browserId: String,
        @RequestParam(name = "url", required = true) url: String
    ): ResponseEntity.BodyBuilder {
        browserService.start(userId, browserId, url);
        return ResponseEntity.ok()
    }

    @GetMapping("/geturl")
    @Operation(summary = "Get the desired browsers active URL")
    fun getURL(
        @PathVariable("userId") userId: String,
        @PathVariable("browserId") browserId: String,
    ): ResponseEntity.BodyBuilder {
        var url: String = browserService.getURL(userId, browserId);
        return ResponseEntity.ok()
    }

    @GetMapping("/stop")
    @Operation(summary = "Start the desired browser and open the URL")
    fun stopBrowser(
        @PathVariable("userId") userId: String,
        @PathVariable("browserId") browserId: String
    ): ResponseEntity.BodyBuilder {
        browserService.stop(userId, browserId);
        return ResponseEntity.ok()
    }

    @GetMapping("/cleanup")
    @Operation(summary = "Start the desired browser and open the URL")
    fun cleanup(
        @PathVariable("userId") userId: String,
        @PathVariable("browserId") browserId: String
    ): ResponseEntity.BodyBuilder {
        browserService.cleanup(userId, browserId);
        return ResponseEntity.ok()
    }
}