package com.virtusa.ibs.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.ibs.dto.Logger;


@Repository
public interface LoggerRepository extends CrudRepository<Logger, Integer> {

}
