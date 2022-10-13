package vn.quangbui26.redis_spring_boot.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import vn.quangbui26.redis_spring_boot.models.Book;
import vn.quangbui26.redis_spring_boot.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookCacheService bookCacheService;

    public BookService(BookRepository bookRepository, BookCacheService bookCacheService) {
        this.bookRepository = bookRepository;
        this.bookCacheService = bookCacheService;
    }

    public Book createBook(Book book) {
        bookCacheService.clearBookListCache();
        return bookRepository.save(book);
    }

    @CacheEvict(value = "books", key = "#book_id")
    public Book modifyBook(Long book_id, Book book) {
        bookCacheService.clearBookListCache();
        Book b = bookRepository.findById(book_id).orElseThrow();
        book.setId(b.getId());
        return bookRepository.save(book);
    }

    @CacheEvict(value = "books", key = "#book_id")
    public void deleteBook(Long book_id) {
        bookCacheService.clearBookListCache();
        bookRepository.deleteById(book_id);
    }

    @Cacheable(value = "books_list")
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Cacheable(value = "books", key = "#book_id")
    public Book getBook(Long book_id) {
        return bookRepository.findById(book_id).orElseThrow();
    }

}
