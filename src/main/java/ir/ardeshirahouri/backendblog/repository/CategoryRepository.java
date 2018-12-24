package ir.ardeshirahouri.backendblog.repository;

import ir.ardeshirahouri.backendblog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
