package com.ngdp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ngdp.bean.ResultObj;
import com.ngdp.exception.ErrorCode;
import com.ngdp.exception.SystemException;
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
	
	@GetMapping("/{code}")
	public ResultObj get(@PathVariable("code")int peopleId  ){
		System.out.println(peopleId);
		return successReturn();
	}
	
	@PostMapping("/{type}")
	public ResultObj add(@PathVariable("type")String type,@Valid @RequestBody People people,BindingResult result){
		System.out.println(type);
		if(result.hasErrors()){
			String message = "";
			List<FieldError> fieldErrors = result.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				message = message.concat(fieldError.getDefaultMessage()).concat(";"); 
			}
			throw new SystemException(message);
		}else{
			System.out.println(people);
			return successReturn(people);
		}

	}
}
