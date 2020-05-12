package pojo.trans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 课程分类(修改信息)实体类
 */
@ApiModel(value = "课程分类实体类(修改信息)" , description = "课程分类描述信息(修改信息)")
public class UpdateCourseType {
    //主键
    @ApiModelProperty(value = "主键")
    private Long id;

    //分类名称
    @ApiModelProperty(value = "分类名称")
    private String categoryName;

    //排序
    @ApiModelProperty(value = "排序")
    private Integer sort;

    //备注
    @ApiModelProperty(value = "备注")
    private String remark;

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
