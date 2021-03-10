package com.yuvaan.stage5.winemanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.yuvaan.stage5.winemanager.entity.Wine;
import com.yuvaan.stage5.winemanager.repository.WineRepository;

@Service
public class WineService {
	@Autowired
	WineRepository wineRepository;
	
	public Wine addWine(final Wine wine) {
		return wineRepository.save(wine);
	}

	public Optional<Wine> getWineById(final Integer id) {
		return wineRepository.findById(id);
	}
	
	public void deleteWine(final Integer id) {
		wineRepository.deleteById(id);
	}
	
	public boolean updateWine(final Wine wine) {
		boolean isWineUpdated = false;
		if(wineRepository.findById(wine.getId()).isPresent())
			isWineUpdated = true;
		 wineRepository.save(wine);
		 return isWineUpdated;
	}

	public List<Wine> findAll() {
		return wineRepository.findAll();
	}

	public Page<Wine> findAllPage(Pageable pageable) {
		return wineRepository.findAll(pageable);
	}

	public List<Wine> findAllSorted(Sort sort) {
		return wineRepository.findAll(sort);
	}
}
