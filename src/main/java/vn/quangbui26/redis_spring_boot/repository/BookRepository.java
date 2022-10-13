package vn.quangbui26.redis_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.quangbui26.redis_spring_boot.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
