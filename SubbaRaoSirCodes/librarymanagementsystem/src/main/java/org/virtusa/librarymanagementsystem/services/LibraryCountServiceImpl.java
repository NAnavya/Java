package org.virtusa.librarymanagementsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.virtusa.librarymanagementsystem.entities.Library;
import org.virtusa.librarymanagementsystem.repositories.LibraryRepository;

@Service
public class LibraryCountServiceImpl implements LibraryCountService {
	@Autowired
	private LibraryRepository libraryRepository;
	@Override
	public long countLibraries() {
		return libraryRepository.count();
	}

	@Override
	public long countLibrariesWithZeroBooks() {
		Library library=new Library();
		library.setCommaSeperatedBookNames("");
		ExampleMatcher exampleMatcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", ExampleMatcher.
						GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, exampleMatcher);
		return libraryRepository.count(example);
	}

}
