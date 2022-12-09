package guru.springframework.sdjpa.wp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "wp_comments", indexes = {
        @Index(name = "comment_post_ID", columnList = "comment_post_ID"),
        @Index(name = "comment_approved_date_gmt", columnList = "comment_approved, comment_date_gmt"),
        @Index(name = "comment_date_gmt", columnList = "comment_date_gmt"),
        @Index(name = "comment_parent", columnList = "comment_parent"),
        @Index(name = "comment_author_email", columnList = "comment_author_email")
})
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Size(max = 20)
    @Column(name = "comment_ID", length = 20)
    private Long id;

    @Column(name = "comment_post_ID", length = 20)
    @NotNull
    @Size(max = 20)
    private Long postId;

    @Column(name = "comment_author")
    @NotNull
    @Size(max = 255)
    private String author;

    @Email
    @Column(name = "comment_author_email", length = 100)
    @NotNull
    @Size(max = 100)
    private String authorEmail;

    @URL
    @Column(name = "comment_author_url", length = 200)
    @NotNull
    @Size(max = 200)
    private String authorUrl;

    @Column(name = "comment_author_IP", length = 100)
    @NotNull
    @Size(max = 100)
    private String authorIP;

    @Column(name = "comment_date")
    @NotNull
    private Timestamp commentDate;

    @Column(name = "comment_date_gmt")
    @NotNull
    private Timestamp dateGmt;

    @Column(name = "comment_content", columnDefinition = "text")
    @NotNull
    @Lob
    private String content;

    @Column(name = "comment_karma", length = 11)
    @NotNull
    @Size(max = 11)
    private Integer karma;

    @Column(name = "comment_approved")
    @NotNull
    @Size(max = 20)
    private String approved;

    @Column(name = "comment_agent")
    @NotNull
    @Size(max = 255)
    private String agent;

    @Column(name = "comment_type")
    @NotNull
    @Size(max = 20)
    private String commentType;

    @Column(name = "comment_parent")
    @NotNull
    @Size(max = 20)
    private Long commentParent;

    @OneToMany(mappedBy = "comment")
    private Set<CommentMeta> commentMetaSet;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getAuthorIP() {
        return authorIP;
    }

    public void setAuthorIP(String authorIP) {
        this.authorIP = authorIP;
    }

    public Timestamp getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Timestamp commentDate) {
        this.commentDate = commentDate;
    }

    public Timestamp getDateGmt() {
        return dateGmt;
    }

    public void setDateGmt(Timestamp dateGmt) {
        this.dateGmt = dateGmt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getKarma() {
        return karma;
    }

    public void setKarma(Integer karma) {
        this.karma = karma;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    public Long getCommentParent() {
        return commentParent;
    }

    public void setCommentParent(Long commentParent) {
        this.commentParent = commentParent;
    }

    public Set<CommentMeta> getCommentMetaSet() {
        return commentMetaSet;
    }

    public void setCommentMetaSet(Set<CommentMeta> commentMetaSet) {
        this.commentMetaSet = commentMetaSet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
