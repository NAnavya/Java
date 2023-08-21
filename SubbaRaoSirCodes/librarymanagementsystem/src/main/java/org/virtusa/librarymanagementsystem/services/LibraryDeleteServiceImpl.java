package org.virtusa.librarymanagementsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtusa.librarymanagementsystem.entities.Library;
import org.virtusa.librarymanagementsystem.repositories.LibraryRepository;

@Service
public class LibraryDeleteServiceImpl implements LibraryDeleteService{
	@Autowired
	private LibraryRepository libraryRepository;
	@Override
	public String deleteLibrary(Library library) {
		libraryRepository.delete(library);
		return "Deleted Library "+library;
	}

	@Override
	public String pruneTable() {
		libraryRepository.deleteAll();
		return "Prune Completed";
	}

	@Override
	public String deleteAllThese(List<Library> libraries) {
		libraryRepository.deleteAll(libraries);
		return "Delete All Completed";
	}

	@Override
	public String deleteAllInBatch() {
		libraryRepository.deleteAllInBatch();
		return "Delete All in Batch Completed";
	}

	@Override
	public String deleteLibraryById(int id) {

		libraryRepository.deleteById(id);
		return "Library With id :"+id+" is deleted";
	}

	@Override
	public String deleteAllTheseInBatch(List<Library> libraries) {
		libraryRepository.deleteAllInBatch(libraries);
		return "Delete all the libraries in the list in batch mode";
	}

}
