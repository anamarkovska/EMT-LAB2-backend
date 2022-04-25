package emt.web;

import emt.model.Book;
import emt.model.dto.BookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import emt.service.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "https://library-emt-lab2-193025.herokuapp.com/")
@RequestMapping("/api/books")
public class BookRestController {
    BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.findAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        Optional<Book> book = bookService.findById(id);
        return book.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto){
        Optional<Book> book = bookService.saveBook(bookDto);
        return book.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Book> save(@PathVariable Long id, @RequestBody BookDto bookDto){
        Optional<Book> book = bookService.editBook(id, bookDto);
        return book.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        try{
            this.bookService.deleteById(id);
        }
        catch (RuntimeException e){
            System.out.println("?????????? BOOOK WITH ID " + e.getMessage() + "    ?????? ");
        }
    }

    @PutMapping("/take/{id}")
    public ResponseEntity<Book> takeBook(@PathVariable Long id){
        try{
            this.bookService.decreaseAvailableCopiesForBook(id);
            return ResponseEntity.ok().body(bookService.findById(id).get());
        }
        catch (RuntimeException e){
            return ResponseEntity.badRequest().build();
        }
    }

}
