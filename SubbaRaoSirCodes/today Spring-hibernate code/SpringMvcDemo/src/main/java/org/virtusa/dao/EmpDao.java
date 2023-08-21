package org.virtusa.dao;

import java.util.List;
import java.util.Optional;

import org.virtusa.entities.Emp;

public interface EmpDao {
	void insert(Emp e);
	void delete(int eno);
	List<Emp> getAll();
	Optional<Emp> get(int eno);
}
