package com.weixuan.shorturl.shortener;

import com.weixuan.shorturl.repository.URLRepository;
import com.weixuan.shorturl.repository.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Random;

@Service
public class ShortService {

    @Autowired
    private  URLRepository urlRepository;

    private static final String base62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final long base = base62.length();

    private long probe = 0;


    public String getShortenURL(String url) {
        Url newUrl = new Url();

        Random random = new Random();
        long index = random.nextInt(916132832 - 1);
        if (urlRepository.existsById(index)) {
            boolean isSaved = false;
            while (!isSaved) {
                if (urlRepository.existsById(probe)) {
                    probe++;
                } else {
                    isSaved = true;
                }
            }
            index = probe;
        }

        newUrl.setId(index);
        newUrl.setLongUrl(url);
        Url savedUrl = urlRepository.save(newUrl);
        long id = savedUrl.getId();

        return getEncodedId(id);
    }

    public String getCustomURL(String url, String custom) {
        Url newUrl = new Url();
        long index = getDecodedId(custom);

        if (custom.length() > 5) {
            return "invalid";
        }

        if (urlRepository.existsById(index)) {
            return "exists";
        }

        if (index >= 0 && index < 916132832) {
            newUrl.setId(index);
            newUrl.setLongUrl(url);
            Url savedUrl = urlRepository.save(newUrl);
            long id = savedUrl.getId();

            return getEncodedId(id);
        }

        return "invalid";
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
            return Character.toString(base62.charAt(0));
        }

        while (id > 0) {
            id = fromBase10(id, sb);
        }

        return sb.reverse().toString();
    }

    private static long fromBase10(long i, final StringBuilder sb) {
        long temp = i % base;
        sb.append(base62.charAt((int)temp));

        return i / base;
    }

    public long getDecodedId(String id) {
        return toBase10(new StringBuilder(id).reverse().toString().toCharArray());
    }

    private static long toBase10(char[] chars) {
        long n = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            n += toBase10(base62.indexOf(chars[i]), i);
        }

        return n;
    }

    private static long toBase10(int n, int pow) {
        return n * (int) Math.pow(base, pow);
    }

}
