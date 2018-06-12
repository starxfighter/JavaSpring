package com.starxfighter.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.starxfighter.books.models.Book;
import com.starxfighter.books.repos.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	// returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
    
    public Book updateBookA(Long id, String title, String desc, String lang, Integer pages) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
    	if(optionalBook.isPresent()) {
    		Book temp = optionalBook.get();
    		temp.setTitle(title);
    		temp.setDescription(desc);
    		temp.setLanguage(lang);
    		temp.setNumberOfPages(pages);
    		return bookRepository.save(temp);
    	} else {
    		return null;
    	}
    }
    
    public Book updateBook(Book b) {
    	return bookRepository.save(b);
    }
    
    
}
