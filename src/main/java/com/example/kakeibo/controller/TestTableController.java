package com.example.kakeibo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kakeibo.entity.TestTable;
import com.example.kakeibo.repository.TestTableRepository;





@RestController
public class TestTableController {
	@Autowired
	private TestTableRepository testTableRepository;

	@GetMapping("/add")
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String email) {

		TestTable testEntity = new TestTable();
		testEntity.setId(0);
		testTableRepository.save(testEntity);
		return "saved";
	}

	@GetMapping("/all")
	public @ResponseBody Iterable<TestTable> getAllDatas() {

		return testTableRepository.findAll();
	}
}