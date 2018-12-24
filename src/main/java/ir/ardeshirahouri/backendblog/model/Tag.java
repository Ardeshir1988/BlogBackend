package ir.ardeshirahouri.backendblog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Integer tagId;
    @Column(name = "tag_name")
    private String tagName;
//    @ManyToMany(cascade = { CascadeType.PERSIST })
//    @JoinTable(
//            name = "post_tag",
//            joinColumns = { @JoinColumn(name = "tag_id") },
//            inverseJoinColumns = { @JoinColumn(name = "post_id") }
//    )

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    Set<Post> posts = new HashSet<>();
    public Tag(){}
    public Tag(String tagName) {
        this.tagName = tagName;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
