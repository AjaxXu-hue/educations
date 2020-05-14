package pojo.com;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 课程分类(新增信息)实体类
 */
@ApiModel(value = "课程分类实体类(新增信息)" , description = "课程分类描述信息(新增信息)")
public class InsertCourseType {

    //主键
    @ApiModelProperty(value = "父类主键" )
    private Long parentId;

    //分类名称
    @ApiModelProperty(value = "分类名称")
    private String categoryName;

    //排序
    @ApiModelProperty(value = "排序")
    private Integer sort;

    //备注
    @ApiModelProperty(value = "备注")
    private String remark;


    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
