package com.weixuan.shorturl.shortener;

import com.weixuan.shorturl.repository.URLRepository;
import com.weixuan.shorturl.repository.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortService {

    @Autowired
    private URLRepository URLRepository;

    public String getShortenURL(String url) {
        return "short url";
    }

    public List<Url> getURLs() {
        return URLRepository.findAll();
    }

}
