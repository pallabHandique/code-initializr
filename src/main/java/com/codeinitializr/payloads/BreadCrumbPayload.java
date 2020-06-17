package com.codeinitializr.payloads;

import java.util.Objects;

/**
 * BreadCrumbPayload
 */
public class BreadCrumbPayload {

    Long id;
    String title;
    String slug;


    public BreadCrumbPayload() {
    }

    public BreadCrumbPayload(Long id, String title, String slug) {
        this.id = id;
        this.title = title;
        this.slug = slug;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public BreadCrumbPayload id(Long id) {
        this.id = id;
        return this;
    }

    public BreadCrumbPayload title(String title) {
        this.title = title;
        return this;
    }

    public BreadCrumbPayload slug(String slug) {
        this.slug = slug;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BreadCrumbPayload)) {
            return false;
        }
        BreadCrumbPayload breadCrumbPayload = (BreadCrumbPayload) o;
        return Objects.equals(id, breadCrumbPayload.id) && Objects.equals(title, breadCrumbPayload.title) && Objects.equals(slug, breadCrumbPayload.slug);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, slug);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", slug='" + getSlug() + "'" +
            "}";
    }

}