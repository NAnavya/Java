package org.virtusa.librarymanagementsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.virtusa.librarymanagementsystem.entities.Library;
import org.virtusa.librarymanagementsystem.repositories.LibraryRepository;

@Service
public class LibraryExistsServiceImpl implements LibraryExistsService{
	@Autowired
	private LibraryRepository libraryRepository;
	@Override
	public boolean checkLibraryExistsById(int id) {
		return libraryRepository.existsById(id);
	}
	@Override
	public boolean checkLibraryExistsWithBooks(String commaSeperatedBookNames) {
		Library library=new Library();
		library.setCommaSeperatedBookNames(commaSeperatedBookNames);
		ExampleMatcher exampleMatcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, exampleMatcher);
		return libraryRepository.exists(example);
	}

}
