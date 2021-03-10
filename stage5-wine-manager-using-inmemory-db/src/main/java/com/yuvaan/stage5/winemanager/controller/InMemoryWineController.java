package com.yuvaan.stage5.winemanager.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Slice;

import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yuvaan.stage5.winemanager.entity.Wine;
import com.yuvaan.stage5.winemanager.exception.NoWineDataException;
import com.yuvaan.stage5.winemanager.exception.WineNotFoundException;
import com.yuvaan.stage5.winemanager.service.WineService;

@RequestMapping("/wine-manager/v2")
@RestController
public class InMemoryWineController {

	private static final Logger LOGGER = LoggerFactory.getLogger(InMemoryWineController.class);

	@Autowired
	private WineService wineService;

	@GetMapping(value = "wines/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Wine getWineById(@PathVariable int id) {
		LOGGER.info("Executing GET wine by ID, with ID {}", id);
		Optional<Wine> wine = wineService.getWineById(id);
		if (wine.isPresent())
			return wine.get();
		else {
			LOGGER.error("There is no wine with Id : {}", id);
			throw new WineNotFoundException("There is no wine with Id : " + id);
		}

	}

	@DeleteMapping(value = "wines/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteWineById(@PathVariable int id) {
		LOGGER.info("Executing DELETE wine by ID, with ID {}", id);
		Optional<Wine> wine = wineService.getWineById(id);
		if (wine.isPresent())
			wineService.deleteWine(id);
		else {
			LOGGER.error("There is no wine with Id : {}", id);
			throw new WineNotFoundException("There is no wine with Id : " + id);
		}

	}

	@PostMapping("wines")
	public ResponseEntity<Wine> createWine(@RequestBody final Wine wine) {
		LOGGER.info("Executing POST/CREATE wine with JSON {}", wine.toString());
		wineService.addWine(wine);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(wine.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	@PutMapping("wines")
	public ResponseEntity<Wine> updateWine(@RequestBody final Wine wine) {
		LOGGER.info("Executing PUT/UPDATE wine with JSON {}", wine.toString());
		boolean isUpdated = wineService.updateWine(wine);
		if (isUpdated) {
			return ResponseEntity.ok(wine);
		} else {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(wine.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		}

	}

	@GetMapping("wines")
	public List<Wine> getAllWine() {
		LOGGER.info("Executing GET ALL wine");
		List<Wine> wineList = wineService.findAll();
		if(wineList != null & wineList.size() > 0)
			return wineService.findAll();
		else
			throw new NoWineDataException("No wine exists in the DB");
	}
	
	@GetMapping(path = "/wines/page")
	Page<Wine> loadWinePage(
			@PageableDefault(page = 0, size = 3)
			@SortDefault.SortDefaults({
					@SortDefault(sort = "name", direction = Sort.Direction.DESC),
					@SortDefault(sort = "id", direction = Sort.Direction.ASC)
			})
		Pageable pageable) {
		return wineService.findAllPage(pageable);
	}
	
	@GetMapping(path = "/wine/sorted")
	List<Wine> loadCharactersSorted(Sort sort) {
		return wineService.findAllSorted(sort);
	}


}
