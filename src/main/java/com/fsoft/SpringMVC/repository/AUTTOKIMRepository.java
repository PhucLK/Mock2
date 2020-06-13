package com.fsoft.SpringMVC.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fsoft.SpringMVC.entity.AUTTOKIM;

/**
 * @author PhucTV7
 *
 * Version 1.0
 *
 * @date 2020-Jun-11
 *
 * Copyright
 *
 */
@Repository
public interface AUTTOKIMRepository extends CrudRepository<AUTTOKIM, String> {

}
