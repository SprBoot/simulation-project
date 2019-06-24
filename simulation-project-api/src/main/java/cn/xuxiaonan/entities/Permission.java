package cn.xuxiaonan.entities;

/***
* @Description: 权限实体类
* @Author: dinggc
* @Date: 2019/6/4
*/
public class Permission extends Base{
    /**
     * 权限
     */
    private String permissionName;
    /**
     * 描述
     */
    private String description;

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
