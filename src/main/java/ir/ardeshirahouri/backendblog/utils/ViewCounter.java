package ir.ardeshirahouri.backendblog.utils;


import ir.ardeshirahouri.backendblog.service.PostService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ViewCounter {
    @Autowired
    PostService postService;

    @After("execution(* ir.ardeshirahouri.backendblog.controller.PostController.findPostByPostId(..)) && args(postId))")
    private void increasePostView(Integer postId)
    {
        postService.increasePostViewCounter(postId);
    }

}
