package ir.ardeshirahouri.backendblog.repository;

import ir.ardeshirahouri.backendblog.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TagRepository extends JpaRepository<Tag,Integer> {
    Tag findByTagName(String tagName);
}
