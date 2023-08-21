package org.virtusa.librarymanagementsystem.services;

import java.util.List;

import org.virtusa.librarymanagementsystem.entities.Library;

public interface LibraryDeleteService {
	String deleteLibrary(Library library);
	String pruneTable();
	String deleteAllThese(List<Library> libraries);
	String deleteAllInBatch();
	String deleteLibraryById(int id);
	String deleteAllTheseInBatch(List<Library> libraries);
}
