/**
 * FileName: experiment
 * Author:   dinggc
 * Date:     2019/6/24 20:59
 * Description: 实验类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.entities;

/**
 * 〈一句话功能简述〉<br> 
 * 〈实验类〉
 *
 * @author dinggc
 * @create 2019/6/24
 * @since 1.0.0
 */
public class Experiment extends Base{
    /*
    实验名称
     */
    private String name;
    /*
    实验的封面图片id
     */
    private String coverId;
    /*
    实验的简介内容
     */
    private String context;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverId() {
        return coverId;
    }

    public void setCoverId(String coverId) {
        this.coverId = coverId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}