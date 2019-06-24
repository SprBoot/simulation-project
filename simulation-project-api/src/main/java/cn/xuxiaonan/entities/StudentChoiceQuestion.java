/**
 * FileName: StudentChoiceQuestion
 * Author:   dinggc
 * Date:     2019/6/24 21:29
 * Description: 学生选择题回答类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.entities;

/**
 * 〈一句话功能简述〉<br> 
 * 〈学生选择题回答类〉
 *
 * @author dinggc
 * @create 2019/6/24
 * @since 1.0.0
 */
public class StudentChoiceQuestion extends Base{
    /*
    题目
     */
    private String topic;
    /*
    选项
     */
    private String option;
    /*
    选项答案
     */
    private String optionAnswer;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getOptionAnswer() {
        return optionAnswer;
    }

    public void setOptionAnswer(String optionAnswer) {
        this.optionAnswer = optionAnswer;
    }
}