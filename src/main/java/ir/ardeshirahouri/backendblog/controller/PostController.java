package ir.ardeshirahouri.backendblog.controller;


import ir.ardeshirahouri.backendblog.model.Post;
import ir.ardeshirahouri.backendblog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",methods = RequestMethod.GET)
@RequestMapping(ResourceConstants.Blog_POST)

public class PostController {
    private PostService postService;

    PostController(PostService postService){
        this.postService=postService;
    }

    @GetMapping(path = "")
    public ResponseEntity<?> findAllPost() {
        return new ResponseEntity<>(postService.findAllPosts(),HttpStatus.OK);
    }
    @GetMapping(path = "/findbyid")
    public ResponseEntity<Post> findPostByPostId(@RequestParam("id") Integer id) {
        return new ResponseEntity<>(postService.findPostById(id),HttpStatus.OK);
    }
    @GetMapping(path = "/findbycategory")
    public ResponseEntity<List<Post>> findAllPostsByCategory(@RequestParam("catid") Integer categoryId){
        return new ResponseEntity<>(postService.findAllPostsByCategory(categoryId),HttpStatus.OK);
    }
    @GetMapping(path = "/findallbytag")
    public ResponseEntity<List<Post>> findAllPostsByTag(@RequestParam("tagname") String tagName){
        return new ResponseEntity<>(postService.findAllPostsByTagName(tagName),HttpStatus.OK);
    }
    @GetMapping(path = "/findbykeyword")
    public ResponseEntity<List<Post>> findByTitleAndContent(@RequestParam("keyword") String keyword){
        return new ResponseEntity<>(postService.findAllPostsByKeyword(keyword,keyword),HttpStatus.OK);
    }

}