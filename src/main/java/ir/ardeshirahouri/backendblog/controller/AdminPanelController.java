package ir.ardeshirahouri.backendblog.controller;


import ir.ardeshirahouri.backendblog.dto.DashboardStatistics;
import ir.ardeshirahouri.backendblog.dto.ServiceResponse;
import ir.ardeshirahouri.backendblog.model.Category;
import ir.ardeshirahouri.backendblog.model.Post;
import ir.ardeshirahouri.backendblog.model.Tag;
import ir.ardeshirahouri.backendblog.service.AdminPanelService;
import ir.ardeshirahouri.backendblog.service.CategoryService;
import ir.ardeshirahouri.backendblog.service.PostService;
import ir.ardeshirahouri.backendblog.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

@RestController
@CrossOrigin(origins = "*")
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping(path = ResourceConstants.Blog_ADMIN_PANEL)
public class AdminPanelController {

    private AdminPanelService adminPanelService;
    private PostService postService;
    private TagService tagService;
    private CategoryService categoryService;

    AdminPanelController(AdminPanelService adminPanelService,
                         PostService postService,
                         CategoryService categoryService,
                         TagService tagService) {
        this.adminPanelService=adminPanelService;
        this.postService=postService;
        this.categoryService=categoryService;
        this.tagService=tagService;
    }

    @GetMapping("/statistics")
    public DashboardStatistics getStatistic() {
        return adminPanelService.getStatistics();
    }
    @GetMapping("/post")
    public ResponseEntity<?> getAllPosts() {
        return new ResponseEntity<>(postService.findAllPosts(),HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity<?> savePost(@RequestBody Post post) {
        post.setPostView(0);
        return new ResponseEntity<>(postService.saveAndUpdatePost(post),HttpStatus.OK);
    }
//    @PutMapping("/post")
//    public ResponseEntity<?> updatePost(@RequestBody Post post) {
//        return new ResponseEntity<>(postService.saveAndUpdatePost(post),HttpStatus.OK);
//    }
    @DeleteMapping("/post")
    public ResponseEntity<?> deletePost(@RequestParam("postid") Integer postId) {
        return new ResponseEntity<>(postService.deletePost(postId),HttpStatus.OK);
    }
    @GetMapping("/category")
    public ResponseEntity<?> getAllCategories() {
        return new ResponseEntity<>(categoryService.findAllCategory(),HttpStatus.OK);
    }
    @PostMapping("/category")
    public ResponseEntity<?> saveCategory(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.saveAndUpdateCategory(category),HttpStatus.OK);
    }
//    @PutMapping("/category")
//    public ResponseEntity<?> updateCategory(@RequestBody Category category){
//        return new ResponseEntity<>(categoryService.saveAndUpdateCategory(category),HttpStatus.OK);
//    }
    @DeleteMapping("/category")
    public ResponseEntity<?> deleteCategory(@RequestParam("categoryid") Integer categoryid){
        return new ResponseEntity<>(categoryService.deleteCategory(categoryid),HttpStatus.OK);
    }
    @GetMapping("/tag")
    public ResponseEntity<?> getAllTags() {
        return new ResponseEntity<>( tagService.findAllTag(),HttpStatus.OK);
    }
    @PostMapping("/tag")
    public ResponseEntity<?> saveTag(@RequestBody Tag tag){
        return new ResponseEntity<>(tagService.saveAndUpdateTag(tag),HttpStatus.OK);
    }
//    @PutMapping("/tag")
//    public ResponseEntity<?> updateTag(@RequestBody Tag tag){
//        return new ResponseEntity<>(tagService.saveAndUpdateTag(tag),HttpStatus.OK);
//    }
    @DeleteMapping("/tag")
    public ResponseEntity<?> deleteTag(@RequestParam("tagid") Integer tagid){
        return new ResponseEntity<>(tagService.deleteTag(tagid),HttpStatus.OK);
    }

    @PostMapping(value = "/uploadfile")
    @ResponseBody
    public ResponseEntity<?> uploadFile(
            @RequestParam("file") MultipartFile uploadfile) {

        try {
            String filename = uploadfile.getOriginalFilename();
            String directory = "/img";
            String filepath = Paths.get(directory, filename).toString();
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            stream.write(uploadfile.getBytes());
            stream.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ServiceResponse("uploaded",null),HttpStatus.OK);
    }

}