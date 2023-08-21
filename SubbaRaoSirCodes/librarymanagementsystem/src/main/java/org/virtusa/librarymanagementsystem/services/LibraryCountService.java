package org.virtusa.librarymanagementsystem.services;

public interface LibraryCountService {
	long countLibraries();
	long countLibrariesWithZeroBooks();
}
