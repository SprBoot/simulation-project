package cn.xuxiaonan.entities;

/**
 * 用户实体类
 */
public class User extends Base{
    /**
    * 用户名
    */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * md5加密的盐
     */
    private String salt;
    /**
     * 手机号
     */
    private String phone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
