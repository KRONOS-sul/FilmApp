package kg.geektech.filmapp.data.models;

import com.google.gson.annotations.SerializedName;

public class Film {
    String id;
    String title;
    @SerializedName("original_title")
    String original_title;
    String description;
    Integer release_date;
    String director;
    String image;

    public Integer getRelease_date() {
        return release_date;
    }

    public String getDirector() {
        return director;
    }

    public String getImage() {
        return image;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getDescription() {
        return description;
    }
}
