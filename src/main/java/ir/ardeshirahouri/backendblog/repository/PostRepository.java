package ir.ardeshirahouri.backendblog.repository;


import ir.ardeshirahouri.backendblog.model.Category;
import ir.ardeshirahouri.backendblog.model.Post;
import ir.ardeshirahouri.backendblog.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post,Integer> {

    Post findByPostId(Integer postId);

    List<Post> getAllByPostCategory(Category category);

    List<Post> getAllByTagsContains(Tag tag);

    List<Post> getAllByPostContentContainingOrPostTitleContaining(String keyword, String k);
}
