package com.rueggerllc.bookcatalog.repository;


import org.springframework.data.repository.CrudRepository;

import com.rueggerllc.bookcatalog.beans.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
	
	public Book findByIsbn(String isbn);

}
