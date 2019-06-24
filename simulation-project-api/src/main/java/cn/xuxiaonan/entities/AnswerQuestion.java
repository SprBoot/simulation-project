/**
 * FileName: AnswerQuestion
 * Author:   dinggc
 * Date:     2019/6/24 20:31
 * Description: 简答题类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.entities;

/**
 * 〈一句话功能简述〉<br> 
 * 〈简答题类〉
 *
 * @author dinggc
 * @create 2019/6/24
 * @since 1.0.0
 */
public class AnswerQuestion extends Base{
    /*
    简答题题目
     */
    private String topic;
    /*
    正确答案
     */
    private String correctAnswer;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}