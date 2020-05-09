package pojo.system;


import java.util.Date;
import java.util.List;

public class Menu {

    private Integer id;//主键
    private String menu_name;//菜单名称
    private String menu_url;//路由路径
    private String api_url;//接口URL
    private Integer parentId;//父ID
    private String menu_icon;//菜单图标
    private boolean menu_type;//菜单类型(1：目录 2：菜单 3：按钮)
    private boolean status_id;//状态(1:正常，0:禁用)
    private String remark;//备注
    private Date gmt_create;//创建时间
    private Date gmt_modified;//修改时间
    private List<Role> roles;

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menu_name='" + menu_name + '\'' +
                ", menu_url='" + menu_url + '\'' +
                ", api_url='" + api_url + '\'' +
                ", parentId=" + parentId +
                ", menu_icon='" + menu_icon + '\'' +
                ", menu_type=" + menu_type +
                ", status_id=" + status_id +
                ", remark='" + remark + '\'' +
                ", gmt_create=" + gmt_create +
                ", gmt_modified=" + gmt_modified +
                ", roles=" + roles +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public String getApi_url() {
        return api_url;
    }

    public void setApi_url(String api_url) {
        this.api_url = api_url;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getMenu_icon() {
        return menu_icon;
    }

    public void setMenu_icon(String menu_icon) {
        this.menu_icon = menu_icon;
    }

    public boolean isMenu_type() {
        return menu_type;
    }

    public void setMenu_type(boolean menu_type) {
        this.menu_type = menu_type;
    }

    public boolean isStatus_id() {
        return status_id;
    }

    public void setStatus_id(boolean status_id) {
        this.status_id = status_id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
