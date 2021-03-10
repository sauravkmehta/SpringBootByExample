package com.yuvaan.stage3.winemanager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuvaan.stage3.winemanager.dao.WineDAO;
import com.yuvaan.stage3.winemanager.dto.Wine;

@RequestMapping("/wine-manager/v1")
@RestController
public class WineController {

	private static final Logger LOGGER = LoggerFactory.getLogger(WineController.class);

	@Autowired
	private WineDAO wineDAO;

	@GetMapping(value = "wines/{id}", produces = MediaType.APPLICATION_XML_VALUE)
	public Wine getWineById(@PathVariable int id) {
		LOGGER.info("Executing GET wine by ID, with ID {}", id);
		return wineDAO.findWineById(id);

	}

	@GetMapping("wines")
	public List<Wine> getAllWine() {
		LOGGER.info("Executing GET ALL wine");
		return wineDAO.findAll();
	}

	@GetMapping("wine/name/{name}")
	public List<Wine> getWineByName(@PathVariable String name) {
		LOGGER.info("Executing GET wine by Name, with name {}", name);
		return wineDAO.findWineByName(name);

	}

}
