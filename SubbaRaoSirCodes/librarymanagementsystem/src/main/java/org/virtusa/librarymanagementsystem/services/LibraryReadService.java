package org.virtusa.librarymanagementsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.virtusa.librarymanagementsystem.entities.Library;

public interface LibraryReadService {
	List<Library> getAllLibraries();
	List<Library> getAllLibrariesWithNoBooks();
	Page<Library> getLibrariesPaged();
	Page<Library> getLibrariesCustomPaged(int pageNumber,int noOfRecordsPage);
	List<Library> getLibrariesWithLatestAddedOrder();
	List<Library> getLibariesCustomSortedById(Direction direction);
	List<Library> getLibariesCustomSortedByName(Direction direction);
	Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeperatedBookNames);
	List<Library> getLibrariedSortedByNameAndWithTheseBooks(String commaSeperatedBookNames);
	List<Library> getLibrariesByIds(List<Integer> ids);
	Optional<Library> getLibraryById(int id);
	Optional<Library> getLibraryWithTheseBooks(String commaSeperatedBookNames);	
}
