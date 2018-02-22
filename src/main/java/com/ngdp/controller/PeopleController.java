package com.ngdp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngdp.bean.ResultObj;
import com.ngdp.model.People;
import com.ngdp.service.PeopleService;

@RestController
@RequestMapping("/api/people/")
public class PeopleController extends BaseController{

	@Autowired
	private PeopleService peopleService;
	
	@GetMapping("/list")
	public ResultObj getAll(){
		List<People> people = peopleService.getPeople();
		return successReturn(people);
	}
	
	@GetMapping("/")
	public ResultObj tee(){
		return successReturn("对对对 钉钉 ");
	}
	
}
