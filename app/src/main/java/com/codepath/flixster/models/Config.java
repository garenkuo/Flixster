package com.codepath.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kcguo on 6/21/17.
 */

public class Config {
    // base url for loading images
    String imageBaseUrl;
    // poster size
    String posterSize;
    // backdrop size
    String backdropSize;

    public Config(JSONObject object) throws JSONException {
        // parse image
        JSONObject images = object.getJSONObject("images");
        // get image base url
        imageBaseUrl = images.getString("secure_base_url");
        // get poster size
        JSONArray posterSizeOptions = images.getJSONArray("poster_sizes");
        // use option at index 3 or w342 as fallback
        posterSize = posterSizeOptions.optString(3, "w342");
        // get backdrop size
        JSONArray backdropSizeOptions = images.getJSONArray("backdrop_sizes");
        // use option at index 1 or w780 as fallback
        backdropSize = backdropSizeOptions.optString(1, "w780");
    }

    // helper method for creating urls
    public String getImageUrl(String size, String path) {
        return String.format("%s%s%s", imageBaseUrl, size, path);
    }
    public String getImageBaseUrl() {
        return imageBaseUrl;
    }

    public String getPosterSize() {
        return posterSize;
    }

    public String getBackdropSize() {
        return backdropSize;
    }
}


