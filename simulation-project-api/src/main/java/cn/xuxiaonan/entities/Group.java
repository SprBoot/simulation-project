/**
 * FileName: Group
 * Author:   dinggc
 * Date:     2019/6/24 21:13
 * Description: 分组类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.entities;

/**
 * 〈一句话功能简述〉<br> 
 * 〈分组类〉
 *
 * @author dinggc
 * @create 2019/6/24
 * @since 1.0.0
 */
public class Group extends Base{
    /*
    分组名称
     */
    private String name;
    /*
    组人数
     */
    private int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}