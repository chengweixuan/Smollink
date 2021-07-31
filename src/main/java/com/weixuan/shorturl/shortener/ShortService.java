package com.weixuan.shorturl.shortener;

import com.weixuan.shorturl.repository.URLRepository;
import com.weixuan.shorturl.repository.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.commons.codec.binary.Base64;

import javax.persistence.EntityNotFoundException;
import java.math.BigInteger;
import java.util.List;

@Service
public class ShortService {

    @Autowired
    private  URLRepository urlRepository;

    private static final String base56 = "23456789abcdefghijkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";
    private static final long base = base56.length();


    public String getShortenURL(String url) {
        Url newUrl = new Url();
        newUrl.setLongUrl(url);
        Url savedUrl = urlRepository.save(newUrl);
        long id = savedUrl.getId();

        return getEncodedId(id);
    }

    public String getLongURL(String code) {
        long id = getDecodedId(code);

        Url originalUrl = urlRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No URL with this code: " + code));

        return originalUrl.getLongUrl();
    }

    public List<Url> getURLs() {
        return urlRepository.findAll();
    }

    public String getEncodedId(long id) {
        StringBuilder sb = new StringBuilder("");

        if (id == 0) {
            return Character.toString(base56.charAt(0));
        }

        while (id > 0) {
            id = fromBase10(id, sb);
        }

        return sb.reverse().toString();
    }

    private static long fromBase10(long i, final StringBuilder sb) {
        long temp = i % base;
        sb.append(base56.charAt((int)temp));

        return i / base;
    }

    public long getDecodedId(String id) {
        return toBase10(new StringBuilder(id).reverse().toString().toCharArray());
    }

    private static long toBase10(char[] chars) {
        long n = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            n += toBase10(base56.indexOf(chars[i]), i);
        }

        return n;
    }

    private static long toBase10(int n, int pow) {
        return n * (int) Math.pow(base, pow);
    }

}
