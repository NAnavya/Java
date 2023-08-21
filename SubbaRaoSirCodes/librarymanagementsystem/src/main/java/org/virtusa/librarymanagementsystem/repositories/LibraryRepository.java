package org.virtusa.librarymanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.virtusa.librarymanagementsystem.entities.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer>{

}
