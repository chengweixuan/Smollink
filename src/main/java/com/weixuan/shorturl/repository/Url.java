package com.weixuan.shorturl.repository;

import javax.persistence.*;

@Entity
@Table(name = "url")
public class Url {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "long_url", nullable = false)
    private String longUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
}
