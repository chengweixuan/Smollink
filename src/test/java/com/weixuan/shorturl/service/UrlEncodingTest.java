package com.weixuan.shorturl.service;

import com.weixuan.shorturl.shortener.ShortService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class UrlEncodingTest {

    private ShortService shortService = new ShortService();

    @Test
    public void encodeIndex() {
        assertEquals("1CDwn", shortService.getEncodedId(23984723));
    }

    @Test
    public void decodeShortUrl() {
        assertEquals(7980787, shortService.getDecodedId("xuan"));
    }
}
