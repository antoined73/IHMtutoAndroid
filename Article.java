package fr.ihm.polytech.com.tuto;


import java.net.URL;
import java.util.Date;

/**
 * Created by user on 22/03/2017.
 */

public class Article {
    private int id;
    private String title;
    private String content;
    private String auteur;
    private Date date;
    private Category category;
    private MediaType mediatype;
    private URL url;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuteur() {
        return auteur;
    }

    public Date getDate() {
        return date;
    }

    public Category getCategory() {
        return category;
    }

    public MediaType getMediatype() {
        return mediatype;
    }

    public URL getUrl() {
        return url;
    }

    public Article(int id, String title, String content, String auteur, Date date, Category category, MediaType mediatype, URL url) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.auteur = auteur;
        this.date = date;
        this.category = category;
        this.mediatype = mediatype;
        this.url = url;
    }

    public String toString(){
        return title;
    }
}
