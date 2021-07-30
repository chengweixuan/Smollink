package com.weixuan.shorturl.shortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortController {

    @Autowired
    private ShortService shortService;

    @PostMapping("/shortenURL")
    public String getShortenURL(@RequestParam String url) {
        return shortService.getShortenURL(url);
    }

}
