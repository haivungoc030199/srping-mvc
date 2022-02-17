package com.laptrinhjavaweb.api.dmin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.dto.NewDTO;

@RestController(value="categoryAPIOfAdmin")
public class CategoryAPI {

	@PostMapping("/api/category")
	public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO)
	{
		return categoryDTO;
				}

	@PostMapping("/api/category")
	public CategoryDTO updateCategory(@RequestBody  CategoryDTO categoryDTO)
	{
		return categoryDTO;
				}
	@PostMapping("/api/category")
	public void deleteCategory(@RequestBody long[] ids)
	{
		
				}
}
