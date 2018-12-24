package ir.ardeshirahouri.backendblog.service;


import ir.ardeshirahouri.backendblog.dto.ServiceResponse;
import ir.ardeshirahouri.backendblog.model.Post;

import java.util.List;

public interface PostService {
    List<Post> findAllPosts();
    List<Post> findAllPostsByTag(Integer tagId);
    List<Post> findAllPostsByTagName(String tagName);
    List<Post> findAllPostsByCategory(Integer categoryId);
    List<Post> findAllPostsByKeyword(String keyword, String k);
    Post findPostById(Integer postId);
    void increasePostViewCounter(Integer postId);
    ServiceResponse saveAndUpdatePost(Post post);
    ServiceResponse deletePost(Integer postId);
}
