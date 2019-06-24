/**
 * FileName: StudentTfQuestion
 * Author:   dinggc
 * Date:     2019/6/24 21:30
 * Description: 学生判断题回答类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.entities;

/**
 * 〈一句话功能简述〉<br> 
 * 〈学生判断题回答类〉
 *
 * @author dinggc
 * @create 2019/6/24
 * @since 1.0.0
 */
public class StudentTfQuestion extends Base{
    /*
    题目
     */
    private String topic;
    /*
    回答
     */
    private int answer;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}