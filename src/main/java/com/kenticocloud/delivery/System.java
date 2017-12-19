/*
 * MIT License
 *
 * Copyright (c) 2017
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.kenticocloud.delivery;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.joda.time.DateTime;
import java.util.List;

/**
 * Content item system attributes
 * <p>
 * Every {@link ContentItem} and {@link ContentType} in a JSON response from the Delivery API contains a system
 * attribute. This attribute represents the System object with information about the retrieved content item
 */
public class System {

    @JsonProperty("id")
    String id;

    @JsonProperty("name")
    String name;

    @JsonProperty("codename")
    String codename;

    @JsonProperty("language")
    String language;

    @JsonProperty("type")
    String type;

    @JsonProperty("sitemap_locations")
    List<String> sitemapLocations;

    @JsonProperty("last_modified")
    DateTime lastModified;

    public System() {
        //Default constructor
    }

    /**
     * Unique identifier of the content item
     * @return identifier
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Display name of the content item
     * @return display name
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Codename of the content item
     * <p>
     * Generated from the content item's display name.
     * @return codename
     */
    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    /**
     * Codename of the language variant
     * @return language variant
     */
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Codename of the content type
     * @return the content type codename
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * A list of sitemap locations the content item is in
     * @return sitemap location strings
     */
    public List<String> getSitemapLocations() {
        return sitemapLocations;
    }

    public void setSitemapLocations(List<String> sitemapLocations) {
        this.sitemapLocations = sitemapLocations;
    }

    /**
     * When was the content item last modified
     * @return Zoned DateTime generated from ISO 8601 formatted string
     */
    public DateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(DateTime lastModified) {
        this.lastModified = lastModified;
    }
}
