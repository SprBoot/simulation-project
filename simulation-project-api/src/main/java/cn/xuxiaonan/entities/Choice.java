/**
 * FileName: Choice
 * Author:   dinggc
 * Date:     2019/6/24 20:46
 * Description: 选择题选项类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.entities;

/**
 * 〈一句话功能简述〉<br> 
 * 〈选择题选项类〉
 *
 * @author dinggc
 * @create 2019/6/24
 * @since 1.0.0
 */
public class Choice extends Base{
    /*
    选项
     */
    private String option;
    /*
    选项内容
     */
    private String context;

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}