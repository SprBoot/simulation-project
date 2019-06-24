/**
 * FileName: ExperimentType
 * Author:   dinggc
 * Date:     2019/6/24 21:06
 * Description: 实验的二级分类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.entities;

/**
 * 〈一句话功能简述〉<br> 
 * 〈实验的二级分类〉
 *
 * @author dinggc
 * @create 2019/6/24
 * @since 1.0.0
 */
public class ExperimentType extends Base{
    /*
    分类名称
     */
    private String name;
    /*
    分类描述
     */
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}