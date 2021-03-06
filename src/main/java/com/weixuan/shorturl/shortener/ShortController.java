package com.weixuan.shorturl.shortener;

import com.weixuan.shorturl.repository.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShortController {

    @Autowired
    private ShortService shortService;

    @PostMapping("/shortenURL")
    public String getShortenURL(@RequestParam String url) {
        return shortService.getShortenURL(url);
    }

    @PostMapping("/getURL")
    public String getLongURL(@RequestParam String code) {
        return shortService.getLongURL(code);
    }

    @GetMapping("/getURLs")
    public List<Url> getURLs() {
        return shortService.getURLs();
    }

    @PostMapping("/getEncodedNumber")
    public String getEncodedNumber(@RequestParam long number) {
        return shortService.getEncodedId(number);
    }

    @PostMapping("/getDecodedNumber")
    public long getDecodedNumber(@RequestParam String code) {
        return shortService.getDecodedId(code);
    }

    @PostMapping("/getCustomURL")
    public String getCustomURL(@RequestParam String url, @RequestParam String custom) {
        return shortService.getCustomURL(url, custom);
    }

}
