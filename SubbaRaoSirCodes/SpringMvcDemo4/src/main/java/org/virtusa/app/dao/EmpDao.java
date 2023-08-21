package org.virtusa.app.dao;

import java.util.List;
import java.util.Optional;

import org.virtusa.app.entities.Emp;

public interface EmpDao {
	void insert(Emp e);
	List<Emp> getAll();
	void delete(int eno);
	Optional<Emp> get(int eno);
	void update(int eno,Emp e);
}
