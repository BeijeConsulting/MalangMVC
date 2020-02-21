package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repositories.ProductRepository;

@RestController
public class IndexController {

	@Autowired
	ProductRepository pr;

	@RequestMapping("/")
	public String index() {
		return "ciao" + pr.findById(1L).toString();
	}

}