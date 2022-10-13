package vn.quangbui26.redis_spring_boot.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vn.quangbui26.redis_spring_boot.models.Book;
import vn.quangbui26.redis_spring_boot.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping(value = "/{book_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book modifyBook(@PathVariable Long book_id, @RequestBody Book book) {
        try {
            return bookService.modifyBook(book_id, book);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{book_id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String deleteBook(@PathVariable Long book_id) {
        try {
            bookService.deleteBook(book_id);
            return "delete success";
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping(value = "/{book_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getAll(@PathVariable Long book_id) {
        try {
            return bookService.getBook(book_id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
