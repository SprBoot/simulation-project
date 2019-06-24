/**
 * FileName: Picture
 * Author:   dinggc
 * Date:     2019/6/24 21:17
 * Description: 图片类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.entities;

/**
 * 〈一句话功能简述〉<br> 
 * 〈图片类〉
 *
 * @author dinggc
 * @create 2019/6/24
 * @since 1.0.0
 */
public class Picture extends Base{
    /*
    原始名称
     */
    private String initialName;
    /*
    新生成的uuid名称
     */
    private String uuidName;
    /*
    图片类型
     */
    private String type;
    /*
    图片地址
     */
    private String address;

    public String getInitialName() {
        return initialName;
    }

    public void setInitialName(String initialName) {
        this.initialName = initialName;
    }

    public String getUuidName() {
        return uuidName;
    }

    public void setUuidName(String uuidName) {
        this.uuidName = uuidName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}