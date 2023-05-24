package mbti.demo.service;

import lombok.RequiredArgsConstructor;
import mbti.demo.exception.ResourceNotFoundException;
import mbti.demo.repository.BookRepository;
import org.springframework.stereotype.Service;
import mbti.demo.entity.Book;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService{

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));

        // Update the book details here. For example:
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());

        Book updatedBook = bookRepository.save(book);
        return updatedBook;
    }

    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
        bookRepository.delete(book);
    }
}
