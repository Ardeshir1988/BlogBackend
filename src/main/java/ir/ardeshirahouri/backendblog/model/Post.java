package ir.ardeshirahouri.backendblog.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer postId;
    @Column(name = "post_title")
    private String postTitle;
    @Column(name = "post_title_url")
    private String postTitleUrl;
    @Column(name = "post_content")
    private String postContent;
    @Column(name = "post_image")
    private String postImage;
//    @ManyToMany(mappedBy = "posts")
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "post_tag",
            joinColumns = { @JoinColumn(name = "post_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") }
    )
    private Set<Tag> tags=new HashSet<>();
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "post_category_id")
    private Category postCategory;
    @Column(name = "post_view")
    private Integer postView;

    @Column(name = "post_date",updatable = false)
    @CreationTimestamp
    private Timestamp postDate;

    public Post(){}
    public Post(String postTitle, String postContent) {
        this.postTitle = postTitle;
        this.postContent = postContent;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostTitleUrl() {
        return postTitleUrl;
    }

    public void setPostTitleUrl(String postTitleUrl) {
        this.postTitleUrl = postTitleUrl;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Category getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(Category postCategory) {
        this.postCategory = postCategory;
    }

    public Integer getPostView() {
        return postView;
    }

    public void setPostView(Integer postView) {
        this.postView = postView;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

}