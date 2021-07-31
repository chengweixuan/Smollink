package com.weixuan.shorturl.shortener;

import com.weixuan.shorturl.repository.URLRepository;
import com.weixuan.shorturl.repository.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortService {

    private final URLRepository urlRepository;

    public ShortService(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String getShortenURL(String url) {
        Url newUrl = new Url();
        newUrl.setLongUrl(url);
        urlRepository.save(newUrl);
        long id = 5;

        return url;
    }

    public List<Url> getURLs() {
        return urlRepository.findAll();
    }

    private String encodeUrl(String url) {
        Url newUrl = new Url();
        newUrl.setLongUrl(url);
        Url savedUrl = urlRepository.save(newUrl);
        long id = savedUrl.getId();

        return Long.toString(id);
    }

}
