package com.yuvaan.stage4.winemanager.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yuvaan.stage4.winemanager.dao.WineDAO;
import com.yuvaan.stage4.winemanager.dto.Wine;
import com.yuvaan.stage4.winemanager.exceptions.WineNotFoundException;

@RequestMapping("/wine-manager/v2")
@RestController
public class UpdatedWineController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UpdatedWineController.class);

	@Autowired
	private WineDAO wineDAO;

	@GetMapping(value = "wines/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Wine getWineById(@PathVariable int id) {
		LOGGER.info("Executing GET wine by ID, with ID {}", id);
		try {
			return wineDAO.findWineById(id);
		} catch (final WineNotFoundException ex) {
			LOGGER.error("Wine not Found with ID : {}" ,id);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wine not Found with ID : " + id, ex);
		}

	}

	@DeleteMapping(value = "wines/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteWineById(@PathVariable int id) {
		LOGGER.info("Executing DELETE wine by ID, with ID {}", id);
		wineDAO.deleteWineById(id);

	}

	// @GetMapping("wines")
	public List<Wine> getWineByName(@RequestParam String name) {
		LOGGER.info("Executing GET wine by request param, with name {}", name);
		return wineDAO.findWineByName(name);

	}

	@PostMapping("wines")
	public ResponseEntity<Wine> createWine(@RequestBody final Wine wine) {
		LOGGER.info("Executing POST/CREATE wine with JSON {}", wine.toString());
		wineDAO.createWine(wine);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(wine.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	@PutMapping("wines")
	public ResponseEntity<Wine> updateWine(@RequestBody final Wine wine) {
		LOGGER.info("Executing PUT/UPDATE wine with JSON {}", wine.toString());
		boolean isUpdated = wineDAO.updateWine(wine);
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
		return wineDAO.findAll();
	}

}
