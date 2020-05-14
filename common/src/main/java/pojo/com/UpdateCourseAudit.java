package pojo.com;

import java.util.Date;

//课程信息-审核(修改操作实体类)
public class UpdateCourseAudit {

    //主键
    private Long id;

    // 课程名称
    private String courseName;

    //原价
    private Double courseOriginal;

    //是否免费：关联字典表
    private Integer isFree;

    // 排序
    private Integer sort;

    //课程介绍
    private String introduce;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getCourseOriginal() {
        return courseOriginal;
    }

    public void setCourseOriginal(Double courseOriginal) {
        this.courseOriginal = courseOriginal;
    }

    public Integer getIsFree() {
        return isFree;
    }

    public void setIsFree(Integer isFree) {
        this.isFree = isFree;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
