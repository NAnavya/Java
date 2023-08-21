package org.virtusa.librarymanagementsystem.services;

import java.util.List;

import org.virtusa.librarymanagementsystem.entities.Library;

public interface LibraryCreateService {
	String addLibrary(Library library);
	String addAllLibraries(List<Library> libraries);
	Library addLibraryWithSaveAndFlush(Library library);
}
