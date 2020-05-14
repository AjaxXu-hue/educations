package pojo.com;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 课程上下架实体类
 */
@ApiModel(value = "课程上下架实体类(修改条件信息)" , description = "课程上下架实体类(修改条件信息)描述信息")
public class UpdateCourseListPut {

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 是否上架(关联字典表)
     */
    @ApiModelProperty(value = "是否上架")
    private Integer isPutaway;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIsPutaway() {
        return isPutaway;
    }

    public void setIsPutaway(Integer isPutaway) {
        this.isPutaway = isPutaway;
    }
}
