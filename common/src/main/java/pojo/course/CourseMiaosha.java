package pojo.course;

import java.util.Date;
import java.io.Serializable;

/**
 * (CourseMiaosha)实体类
 *
 * @author makejava
 * @since 2020-05-20 02:42:04
 */
public class CourseMiaosha implements Serializable {
    /**
    * 编号
    */
    private Long id;
    /**
    * 课程编号
    */
    private Long courseId;
    /**
    * 秒杀价
    */
    private Double miaoshaPrice;
    /**
    * 库存
    */
    private Integer stockCount;
    /**
    * 开始时间
    */
    private Date startDate;
    /**
    * 结束时间
    */
    private Date endDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Double getMiaoshaPrice() {
        return miaoshaPrice;
    }

    public void setMiaoshaPrice(Double miaoshaPrice) {
        this.miaoshaPrice = miaoshaPrice;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}