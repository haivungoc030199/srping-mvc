package com.laptrinhjavaweb.api.dmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.service.INewService;

@RestController(value="newAPIOfAdmin")
public class NewAPI {
	
	@Autowired
	private INewService newService;
	
	@PostMapping("/api/new")
	public NewDTO createNew(@RequestBody NewDTO newDTO)
	{
		return newService.save(newDTO);
				}

	@PostMapping("/api/new")
	public NewDTO updateNew(@RequestBody NewDTO updateNew)
	{
		return newService.save(updateNew);
				}
	@PostMapping("/api/new")
	public void deleteNew(@RequestBody long[] ids)
	{
		newService.delete(ids);
				}
}
