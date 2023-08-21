package org.virtusa.librarymanagementsystem.services;

public interface LibraryExistsService {
	boolean checkLibraryExistsById(int id);
	boolean checkLibraryExistsWithBooks(String commaSeperatedBookNames);
}
