package com.codeinitializr.payloads;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PageableObjectPayload
 */
public class PageableObjectPayload {

    PageDetails pageDetails;
    List<?> objectList = new ArrayList<>();
    List<?> objectList2 = new ArrayList<>();
    List<BreadCrumbPayload> breadcrumbList = new ArrayList<>();
    Object currentObject;
    Object currentObject2;



    public PageableObjectPayload() {
    }

    public PageableObjectPayload(PageDetails pageDetails, List<?> objectList, List<?> objectList2, List<BreadCrumbPayload> breadcrumbList, Object currentObject, Object currentObject2) {
        this.pageDetails = pageDetails;
        this.objectList = objectList;
        this.objectList2 = objectList2;
        this.breadcrumbList = breadcrumbList;
        this.currentObject = currentObject;
        this.currentObject2 = currentObject2;
    }

    public PageDetails getPageDetails() {
        return this.pageDetails;
    }

    public void setPageDetails(PageDetails pageDetails) {
        this.pageDetails = pageDetails;
    }

    public List<?> getObjectList() {
        return this.objectList;
    }

    public void setObjectList(List<?> objectList) {
        this.objectList = objectList;
    }

    public List<?> getObjectList2() {
        return this.objectList2;
    }

    public void setObjectList2(List<?> objectList2) {
        this.objectList2 = objectList2;
    }

    public List<BreadCrumbPayload> getBreadcrumbList() {
        return this.breadcrumbList;
    }

    public void setBreadcrumbList(List<BreadCrumbPayload> breadcrumbList) {
        this.breadcrumbList = breadcrumbList;
    }

    public Object getCurrentObject() {
        return this.currentObject;
    }

    public void setCurrentObject(Object currentObject) {
        this.currentObject = currentObject;
    }

    public Object getCurrentObject2() {
        return this.currentObject2;
    }

    public void setCurrentObject2(Object currentObject2) {
        this.currentObject2 = currentObject2;
    }

    public PageableObjectPayload pageDetails(PageDetails pageDetails) {
        this.pageDetails = pageDetails;
        return this;
    }

    public PageableObjectPayload objectList(List<?> objectList) {
        this.objectList = objectList;
        return this;
    }

    public PageableObjectPayload objectList2(List<?> objectList2) {
        this.objectList2 = objectList2;
        return this;
    }

    public PageableObjectPayload breadcrumbList(List<BreadCrumbPayload> breadcrumbList) {
        this.breadcrumbList = breadcrumbList;
        return this;
    }

    public PageableObjectPayload currentObject(Object currentObject) {
        this.currentObject = currentObject;
        return this;
    }

    public PageableObjectPayload currentObject2(Object currentObject2) {
        this.currentObject2 = currentObject2;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PageableObjectPayload)) {
            return false;
        }
        PageableObjectPayload pageableObjectPayload = (PageableObjectPayload) o;
        return Objects.equals(pageDetails, pageableObjectPayload.pageDetails) && Objects.equals(objectList, pageableObjectPayload.objectList) && Objects.equals(objectList2, pageableObjectPayload.objectList2) && Objects.equals(breadcrumbList, pageableObjectPayload.breadcrumbList) && Objects.equals(currentObject, pageableObjectPayload.currentObject) && Objects.equals(currentObject2, pageableObjectPayload.currentObject2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageDetails, objectList, objectList2, breadcrumbList, currentObject, currentObject2);
    }

    @Override
    public String toString() {
        return "{" +
            " pageDetails='" + getPageDetails() + "'" +
            ", objectList='" + getObjectList() + "'" +
            ", objectList2='" + getObjectList2() + "'" +
            ", breadcrumbList='" + getBreadcrumbList() + "'" +
            ", currentObject='" + getCurrentObject() + "'" +
            ", currentObject2='" + getCurrentObject2() + "'" +
            "}";
    }
    

}