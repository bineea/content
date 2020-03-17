package my.blog.content.resources.entity;

import my.blog.content.resources.entity.dict.ContentStatus;


import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDateTime;

@Entity
@Table(name = "blog_content")
public class Content {

    //private User user;// 作者
    private String title;// 标题
    private String text;// 内容
    private String summany;// 摘要
    private Boolean markdownEnable = false;// 是否启用markdown
    private Blob cover;// 封面
    private ContentStatus contentStatus;// 文章状态
    private Integer voteUp = 0;// “顶”的数量
    private Integer commentCount = 0;// 评论数量
    private Integer viewCount = 0;// 访问量
    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间
    private String flag;// 标识
    private Double lat;// 纬度
    private Double lng;// 经度

//    @JoinColumn(name = "user_id")
//    @ManyToOne
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "summany")
    public String getSummany() {
        return summany;
    }

    public void setSummany(String summany) {
        this.summany = summany;
    }

    @Column(name = "markdown_enable")
    public Boolean isMarkdownEnable() {
        return markdownEnable;
    }

    public void setMarkdownEnable(Boolean markdownEnable) {
        this.markdownEnable = markdownEnable;
    }

    @Column(name = "cover")
    public Blob getCover() {
        return cover;
    }

    public void setCover(Blob cover) {
        this.cover = cover;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "content_status")
    public ContentStatus getContentStatus() {
        return contentStatus;
    }

    public void setContentStatus(ContentStatus contentStatus) {
        this.contentStatus = contentStatus;
    }

    @Column(name = "vote_up")
    public Integer getVoteUp() {
        return voteUp;
    }

    public void setVoteUp(Integer voteUp) {
        this.voteUp = voteUp;
    }

    @Column(name = "comment_count")
    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @Column(name = "view_count")
    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    @Column(name = "create_time")
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Column(name = "update_time")
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "flag")
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Column(name = "lat")
    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Column(name = "lng")
    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
