/**
 * FileName: Experiment
 * Author:   dinggc
 * Date:     2019/6/25 15:00
 * Description: es实验类
 * History:
 * <author>  <version>   <desc>
 * dinggc     1.0         描述
 */
package cn.xuxiaonan.simulationprojectes.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈es实验类〉
 *
 * @author dinggc
 * @create 2019/6/25
 * @since 1.0.0
 */
@Document(indexName = "simulation-experiment",type = "experiment",indexStoreType="fs",shards=5,replicas=1,refreshInterval="-1")
public class Experiment implements Serializable {
    /*
    主键id
     */
    @Id
    private String id;
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
    /*
    实验的上传时间
     */
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}