package com.rueggerllc.bookcatalog.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rueggerllc.bookcatalog.beans.Book;
import com.rueggerllc.bookcatalog.repository.BookRepository;

@RefreshScope
@RestController
@RequestMapping("/")
public class BookController {
	
	@Autowired
	private Environment environment;
	
	@Value("${msg:Hello World - Config Server Not working}")
	private String msg;
	
	private BookRepository repo;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public BookController(BookRepository repo) {
		this.repo = repo;
	}
	
	// GET all books
	@GetMapping("/books")
	public Iterable<Book> allBook() {
		logger.info("============ GetBooks BEGIN ==============");
		
		// Profiles
		logger.info("===== Profiles BEGIN ===");
		String[] activeProfiles = environment.getActiveProfiles();
		if (activeProfiles != null) {
			for (String profile : activeProfiles) {
				logger.info("Active Profile = " + profile);
			}
		}
		logger.info("===== Profiles END ===");
		
		// Message
		logger.info("===== Config Values BEGIN ===");
		logger.info("msg=" + msg);
		String message = environment.getProperty("msg");
		logger.info("MESSAGE=" + message);
		logger.info("===== Config Values END ===");
		
		
		return repo.findAll();
	}
	
	// GET book by ISBN
	@GetMapping("/books/isbn/{isbn}")
	public Book getBookByISBN(@PathVariable String isbn) {
		logger.info("Get Book By ISBN: " + isbn);
		return repo.findByIsbn(isbn);
	}
	
	// Save a book
	@PostMapping("/book")
	public String saveBook(@RequestBody Book book) {
		logger.debug("======= Save Book:" + book);
		repo.save(book);
		logger.debug("Book saved successfully in Database");
		return "Book saved successfully in Database";
	}
	
	// Update A Book
	@PutMapping("/book")
	public String updateBook(@RequestBody Book book) {
		logger.debug("======= Update Book:" + book);
		Book bookToUpdate = repo.findByIsbn(book.getIsbn());
		bookToUpdate.setTitle(book.getTitle());
		bookToUpdate.setAuthor(book.getAuthor());
		repo.save(bookToUpdate);
		return "Book Updated in Database";
	}
	
	
	// Delete A Book
	@DeleteMapping("/book")
	public String deleteBook(@PathVariable String isbn) {
		logger.debug("======= Delete Book:" + isbn);
		Book bookToDelete = repo.findByIsbn(isbn);
		logger.info("BookToDelete ID=" + bookToDelete.getId());
		repo.delete(bookToDelete.getId());
		return "Book Deleted from Database";
	}


    
    
}