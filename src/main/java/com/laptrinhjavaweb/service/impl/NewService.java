package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;

@Service
public class NewService implements INewService {
	
	@Autowired
	private NewRepository newRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private NewConverter newConverter;
	
	
	
	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> models=new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll(pageable).getContent();
		for(NewEntity item:entities)
		{
			NewDTO newDTO=newConverter.toDto(item);
			models.add(newDTO);
			
		}
		
		return models;
	}

	@Override
	public int getTotalItem() {
		
		return (int) newRepository.count();
	}

	@Override
	public NewDTO findById(long id) {
		NewEntity entity=newRepository.findOne(id);
		return newConverter.toDto(entity);
	}

	

	@Override
	@Transactional
	public NewDTO save(NewDTO dto) {
		CategoryEntity category =categoryRepository.findOneByCode(dto.getCategoryCode());//find thể loại lên
		NewEntity newEntity=new NewEntity();//khởi tạo
		if(dto.getId() != null)//xét id khác null
		{
			NewEntity oldNew =newRepository.findOne(dto.getId());//find dữ liệu của id cũ lên
			oldNew.setCategory(category);//lấy lên thể loại của id cũ
			newEntity=newConverter.toEntity(oldNew, dto);//conventer từ các giá trị mới vào thay cho 
															//những giá trị cũ và chuyển từ dto sang entity
		}
		else {
			 newEntity=newConverter.toEntity(dto);//save dữ liệu vào trong các trường và chuyển từ dto sang entity
			 newEntity.setCategory(category);//xét thể loại vào 
		}
		return newConverter.toDto(newRepository.save(newEntity));//trả về hàm save truyền vào 
																//entity và converter từ entity sang dto
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for(long id:ids)
		{
			newRepository.delete(id);
		}
	}

	

	

	

}
