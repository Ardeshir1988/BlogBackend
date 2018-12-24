package ir.ardeshirahouri.backendblog.service.imp;

import ir.ardeshirahouri.backendblog.dto.DashboardStatistics;
import ir.ardeshirahouri.backendblog.model.Post;
import ir.ardeshirahouri.backendblog.repository.CategoryRepository;
import ir.ardeshirahouri.backendblog.repository.PostRepository;
import ir.ardeshirahouri.backendblog.repository.TagRepository;
import ir.ardeshirahouri.backendblog.service.AdminPanelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminPanelServiceImpl implements AdminPanelService {

    private PostRepository postRepository;
    private CategoryRepository categoryRepository;
    private TagRepository tagRepository;

    AdminPanelServiceImpl(PostRepository postRepository,CategoryRepository categoryRepository,TagRepository tagRepository){
        this.postRepository=postRepository;
        this.tagRepository=tagRepository;
        this.categoryRepository=categoryRepository;
    }
    @Override
    public DashboardStatistics getStatistics() {
        List<Post> postlist=postRepository.findAll();
        return new DashboardStatistics(postlist.size(),categoryRepository.findAll().size()
                ,tagRepository.findAll().size(),postlist.stream().mapToInt(Post::getPostView).sum());
    }

}
