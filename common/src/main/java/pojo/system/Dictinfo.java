package pojo.system;

import java.io.Serializable;

/**
 * (Dictinfo)实体类 字典明细表
 */
public class Dictinfo implements Serializable {
    /**
    * 主键
    */
    private Integer id;
    /**
    * 类型ID
    */
    private Integer typecode;
    /**
    * 业务代码
    */
    private Integer dictcode;
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypecode() {
        return typecode;
    }

    public void setTypecode(Integer typecode) {
        this.typecode = typecode;
    }

    public Integer getDictcode() {
        return dictcode;
    }

    public void setDictcode(Integer dictcode) {
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