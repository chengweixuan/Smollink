package com.weixuan.shorturl.service;

import com.weixuan.shorturl.repository.URLRepository;
import com.weixuan.shorturl.repository.Url;
import com.weixuan.shorturl.shortener.ShortService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.class)
public class UrlCreationTest {

    @Mock
    URLRepository urlRepository;

    @InjectMocks
    ShortService shortService = new ShortService();

    @Test
    public void createCustomUrlTest() {
        Url url = new Url();
        url.setLongUrl("website.com");
        long id = shortService.getDecodedId("test");
        url.setId(id);

        when(urlRepository.existsById(any(Long.class))).thenReturn(false);
        when(urlRepository.save(any(Url.class))).thenReturn(url);

        assertEquals("test", shortService.getCustomURL("website.com", "test"));
    }

    @Test
    public void getUrlFromCode() {
        Url url = new Url();
        url.setLongUrl("website.com");
        url.setId(0);

        when(urlRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(url));
        assertEquals("website.com", shortService.getLongURL("code"));
    }
}
