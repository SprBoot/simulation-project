package cn.xuxiaonan.simulationprojectes.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

@Document(indexName = "simulation-new",type = "news",indexStoreType="fs",shards=5,replicas=1,refreshInterval="-1")
public class New implements Serializable {
    @Id
    private String id;
    /**
     * 标题
     **/
    private String title;
    /**
     * 新闻内容
     **/
    private String xwnr;
    /**
     * 新闻的封面图片id
     **/
    private String fmtpId;
    /**
     * 发表的机构
     **/
    private String fbjg;
    /**
     * 是否为草稿状态
     **/
    private int sfwcg;
    /**
     * 审核状态
     **/
    private int shzt;
    /**
     * 阅读量
     **/
    private int ydl;
    /**
     * 时间
     **/
    private Date date;
    /**
     * 更新时间
     **/
    private Date gxdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getXwnr() {
        return xwnr;
    }

    public void setXwnr(String xwnr) {
        this.xwnr = xwnr;
    }

    public String getFmtpId() {
        return fmtpId;
    }

    public void setFmtpId(String fmtpId) {
        this.fmtpId = fmtpId;
    }

    public String getFbjg() {
        return fbjg;
    }

    public void setFbjg(String fbjg) {
        this.fbjg = fbjg;
    }

    public int getSfwcg() {
        return sfwcg;
    }

    public void setSfwcg(int sfwcg) {
        this.sfwcg = sfwcg;
    }

    public int getShzt() {
        return shzt;
    }

    public void setShzt(int shzt) {
        this.shzt = shzt;
    }

    public int getYdl() {
        return ydl;
    }

    public void setYdl(int ydl) {
        this.ydl = ydl;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getGxdate() {
        return gxdate;
    }

    public void setGxdate(Date gxdate) {
        this.gxdate = gxdate;
    }
}
