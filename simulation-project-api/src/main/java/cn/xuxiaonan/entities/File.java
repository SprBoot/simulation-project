/**
 * FileName: File
 * Author:   dinggc
 * Date:     2019/6/24 21:07
 * Description: 文件类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.entities;

/**
 * 〈一句话功能简述〉<br> 
 * 〈文件类〉
 *
 * @author dinggc
 * @create 2019/6/24
 * @since 1.0.0
 */
public class File extends Base{
    /*
    文件原始名称
     */
    private String initalName;
    /*
    新生成的uuid名称
     */
    private String uuidName;
    /*
    文件类型
     */
    private String type;
    /*
    文件地址
     */
    private String address;

    public String getInitalName() {
        return initalName;
    }

    public void setInitalName(String initalName) {
        this.initalName = initalName;
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