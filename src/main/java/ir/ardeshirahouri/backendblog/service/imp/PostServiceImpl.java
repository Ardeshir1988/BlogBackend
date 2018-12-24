package ir.ardeshirahouri.backendblog.service.imp;


import ir.ardeshirahouri.backendblog.dto.ServiceResponse;
import ir.ardeshirahouri.backendblog.model.Category;
import ir.ardeshirahouri.backendblog.model.Post;
import ir.ardeshirahouri.backendblog.model.Tag;
import ir.ardeshirahouri.backendblog.repository.CategoryRepository;
import ir.ardeshirahouri.backendblog.repository.PostRepository;
import ir.ardeshirahouri.backendblog.repository.TagRepository;
import ir.ardeshirahouri.backendblog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private CategoryRepository categoryRepository;
    private TagRepository tagRepository;
    PostServiceImpl(PostRepository postRepository, CategoryRepository categoryRepository, TagRepository tagRepository){
        this.postRepository=postRepository;
        this.tagRepository=tagRepository;
        this.categoryRepository=categoryRepository;
    }
    @Override
    public List<Post> findAllPosts() {
        List<Post> postList=postRepository.findAll();
        postList.forEach(post -> post.setPostContent(""));
        Collections.sort(postList,Comparator.comparing(Post::getPostId).reversed());
        return postList;
    }

    @Override
    public List<Post> findAllPostsByTag(Integer tagId) {
        Optional<Tag> postTag=tagRepository.findById(tagId);
        return postTag.map(tag -> postRepository.getAllByTagsContains(tag)).orElse(null);
    }

    @Override
    public List<Post> findAllPostsByTagName(String tagName) {
        Tag tag=tagRepository.findByTagName(tagName);
        return postRepository.getAllByTagsContains(tag);
    }

    @Override
    public List<Post> findAllPostsByCategory(Integer categoryId) {
        Optional<Category> category=categoryRepository.findById(categoryId);
        return category.map(cat -> postRepository.getAllByPostCategory(cat)).orElse(null);
    }

    @Override
    public List<Post> findAllPostsByKeyword(String keyword,String k) {
        return postRepository.getAllByPostContentContainingOrPostTitleContaining(keyword,k);
    }

    @Override
    public Post findPostById(Integer postId) {
        return postRepository.findByPostId(postId);
    }

    @Override
    public void increasePostViewCounter(Integer postId) {
        Post post=postRepository.findByPostId(postId);
        post.setPostView(post.getPostView()+1);
        postRepository.save(post);
    }

    @Override
    public ServiceResponse saveAndUpdatePost(Post post) {


        Post savedPost= postRepository.save(post);

        if (savedPost.getPostId()!=null)
            return new ServiceResponse("post saved",savedPost);
        else
            return new ServiceResponse("failed operation",post);
    }

    @Override
    public ServiceResponse deletePost(Integer postId) {
        postRepository.deleteById(postId);
        return new ServiceResponse("post deleted",new Post());
    }
}
