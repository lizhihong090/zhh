package com.ngdp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ngdp.dao.java.PeopleMapper;
import com.ngdp.model.People;
import com.ngdp.service.PeopleService;

@Service
@Transactional
public class PeopleServiceImpl implements PeopleService {

	@Autowired
	private PeopleMapper mapper;
	
	@Override
	public List<People> getPeople() {
		return mapper.selectAll();
	}

}
