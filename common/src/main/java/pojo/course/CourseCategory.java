package pojo.course;

import io.swagger.annotations.ApiModel;

import java.util.Date;
import java.io.Serializable;

/**
 * 课程分类(CourseCategory)实体类
 */
@ApiModel(value = "课程分类实体类" , description = "课程分类描述信息")
public class CourseCategory {

    //主键
    private Long id;

    //分类名称
    private String categoryName;

    //父分类ID
    private Long parentId;

    //层级
    private Integer floor;

    //排序
    private Integer sort;

    //分类类型(关联字典明细表)
    private Integer categoryType;

    //状态(关联字典明细表)
    private Integer statusId;

    //备注
    private String remark;

    //创建时间
    private Date gmtCreate;

    //修改时间
    private Date gmtModified;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

}