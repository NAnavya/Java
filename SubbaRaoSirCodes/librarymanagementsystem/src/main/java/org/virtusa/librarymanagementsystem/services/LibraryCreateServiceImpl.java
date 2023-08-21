package org.virtusa.librarymanagementsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtusa.librarymanagementsystem.entities.Library;
import org.virtusa.librarymanagementsystem.repositories.LibraryRepository;

@Service
public class LibraryCreateServiceImpl implements LibraryCreateService{
	@Autowired
	private LibraryRepository libraryRepository;
	@Override
	public String addLibrary(Library library) {
		libraryRepository.save(library);
		libraryRepository.flush();
		return "Library Saved";
	}

	@Override
	public String addAllLibraries(List<Library> libraries) {
		libraryRepository.saveAll(libraries);
		libraryRepository.flush();
		return "All Libraries Saved";
	}

	@Override
	public Library addLibraryWithSaveAndFlush(Library library) {
		return libraryRepository.saveAndFlush(library);
	}

}
