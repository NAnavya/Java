package org.virtusa.librarymanagementsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.virtusa.librarymanagementsystem.entities.Library;
import org.virtusa.librarymanagementsystem.repositories.LibraryRepository;

@Service
public class LibraryReadServiceImpl implements LibraryReadService{
	@Autowired
	private LibraryRepository libraryRepository;
	@Override
	public List<Library> getAllLibraries() {
		return libraryRepository.findAll();
	}

	@Override
	public List<Library> getAllLibrariesWithNoBooks() {
		Library library=new Library();
		library.setCommaSeperatedBookNames("");
		ExampleMatcher exampleMatcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, exampleMatcher);
		return libraryRepository.findAll(example);
	}

	@Override
	public Page<Library> getLibrariesPaged() {
		Pageable pageable=PageRequest.of(0, 3);
		return libraryRepository.findAll(pageable);
	}

	@Override
	public Page<Library> getLibrariesCustomPaged(int pageNumber, int noOfRecordsPage) {
		Pageable pageable=PageRequest.of(pageNumber, noOfRecordsPage);
		return libraryRepository.findAll(pageable);
	}

	@Override
	public List<Library> getLibrariesWithLatestAddedOrder() {
		return libraryRepository.findAll(Sort.by(Direction.DESC, "id"));
	}

	@Override
	public List<Library> getLibariesCustomSortedById(Direction direction) {
		return libraryRepository.findAll(Sort.by(direction, "id"));
	}

	@Override
	public List<Library> getLibariesCustomSortedByName(Direction direction) {
		return libraryRepository.findAll(Sort.by(direction, "name"));
	}

	@Override
	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeperatedBookNames) {
		Library library=new Library();
		library.setCommaSeperatedBookNames(commaSeperatedBookNames);
		ExampleMatcher exampleMatcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, exampleMatcher);
		Pageable pageable=PageRequest.of(0, 3, Sort.by("name"));
		return libraryRepository.findAll(example, pageable);
	}

	@Override
	public List<Library> getLibrariedSortedByNameAndWithTheseBooks(String commaSeperatedBookNames) {
		Library library=new Library();
		library.setCommaSeperatedBookNames(commaSeperatedBookNames);
		ExampleMatcher exampleMatcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, exampleMatcher);
		return libraryRepository.findAll(example, Sort.by("name"));
	}

	@Override
	public List<Library> getLibrariesByIds(List<Integer> ids) {
		return libraryRepository.findAllById(ids);
	}

	@Override
	public Optional<Library> getLibraryById(int id) {
		return libraryRepository.findById(id);
	}

	@Override
	public Optional<Library> getLibraryWithTheseBooks(String commaSeperatedBookNames) {
		Library library=new Library();
		library.setCommaSeperatedBookNames(commaSeperatedBookNames);
		ExampleMatcher exampleMatcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, exampleMatcher);
		return libraryRepository.findOne(example);
	}

}
