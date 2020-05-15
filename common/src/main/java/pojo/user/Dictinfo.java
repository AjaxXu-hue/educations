package pojo.user;

import java.io.Serializable;

/**
 * (Dictinfo)实体类 字典明细表
 */
public class Dictinfo {
    /**
    * 主键
    */
    private Long id;
    /**
    * 类型ID
    */
    private Long typecode;
    /**
    * 业务代码
    */
    private Long dictcode;
    /**
    * 配置项名称
    */
    private String info;

    /**
     * 类型名称
     */
    private String typename;
    /**
     * 类型名称(中文)
     */
    private String typenamezh;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTypecode() {
        return typecode;
    }

    public void setTypecode(Long typecode) {
        this.typecode = typecode;
    }

    public Long getDictcode() {
        return dictcode;
    }

    public void setDictcode(Long dictcode) {
        this.dictcode = dictcode;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getTypenamezh() {
        return typenamezh;
    }

    public void setTypenamezh(String typenamezh) {
        this.typenamezh = typenamezh;
    }
}