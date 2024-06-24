package com.alura.book.Books;

import com.alura.book.Books.repository.AuthorsRepository;
import com.alura.book.Books.repository.BooksRepository;
import com.alura.book.Books.repository.RepositoryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksApplication implements CommandLineRunner {

	@Autowired
	private BooksRepository bookrepository;

	@Autowired
	private AuthorsRepository authorsrepository;

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		principal Principal = new principal();
		RepositoryController repositoryController = new RepositoryController ( bookrepository, authorsrepository );
		Principal.menu ();
	}
}
