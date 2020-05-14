package org.search.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.solr.client.solrj.beans.Field;

public class CourseSolr {

    @Field("id")
    private String id;

    @Field("course_name")
    private String courseName;

    @Field("course_logo")
    private String courseLogo;

    @Field("is_free")
    private String isFree;

    @Field("course_original")
    private String courseOriginal;

    @Field("course_discount")
    private String courseDiscount;

    @Field("status_id")
    private String statusId;

    @Field("course_sort")
    private String courseSort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseLogo() {
        return courseLogo;
    }

    public void setCourseLogo(String courseLogo) {
        this.courseLogo = courseLogo;
    }

    public String getIsFree() {
        return isFree;
    }

    public void setIsFree(String isFree) {
        this.isFree = isFree;
    }

    public String getCourseOriginal() {
        return courseOriginal;
    }

    public void setCourseOriginal(String courseOriginal) {
        this.courseOriginal = courseOriginal;
    }

    public String getCourseDiscount() {
        return courseDiscount;
    }

    public void setCourseDiscount(String courseDiscount) {
        this.courseDiscount = courseDiscount;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getCourseSort() {
        return courseSort;
    }

    public void setCourseSort(String courseSort) {
        this.courseSort = courseSort;
    }

}
