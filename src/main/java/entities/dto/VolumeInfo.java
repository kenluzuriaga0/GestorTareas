/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/**
 *
 * @author kenlu
 */
public class VolumeInfo {
    int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("authors")
    @Expose
    ArrayList<String> authors = new ArrayList<String>();

    private String publishedDate;
    private String description;
    private float pageCount;
    ArrayList<String> categories = new ArrayList<String>();
    ImageLinks ImageLinksObject;

    public ArrayList<String> getAuthors() {
            return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }
    

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public ImageLinks getImageLinksObject() {
        return ImageLinksObject;
    }

    public void setImageLinksObject(ImageLinks ImageLinksObject) {
        this.ImageLinksObject = ImageLinksObject;
    }

    // Getter Methods 
    public String getTitle() {
        return title;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public float getPageCount() {
        return pageCount;
    }

    public ImageLinks getImageLinks() {
        return ImageLinksObject;
    }

    // Setter Methods 
    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPageCount(float pageCount) {
        this.pageCount = pageCount;
    }

    public class ImageLinks {

        private String smallThumbnail;

        // Getter Methods 
        public String getSmallThumbnail() {
            return smallThumbnail;
        }

        // Setter Methods 
        public void setSmallThumbnail(String smallThumbnail) {
            this.smallThumbnail = smallThumbnail;
        }
    }
}
