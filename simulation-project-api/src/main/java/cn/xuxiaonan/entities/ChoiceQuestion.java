/**
 * FileName: ChoiceQuestion
 * Author:   dinggc
 * Date:     2019/6/24 20:47
 * Description: 选择题类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.entities;

/**
 * 〈一句话功能简述〉<br> 
 * 〈选择题类〉
 *
 * @author dinggc
 * @create 2019/6/24
 * @since 1.0.0
 */
public class ChoiceQuestion extends Base{
    /*
    题目
     */
    private String topic;
    /*
    选项数量
     */
    private String optionNumber;
    /*
    正确选项
     */
    private String correctOption;
    /*
    正确选项内容
     */
    private String correctAnswer;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getOptionNumber() {
        return optionNumber;
    }

    public void setOptionNumber(String optionNumber) {
        this.optionNumber = optionNumber;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}