package com.yuvaan.stage5.winemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuvaan.stage5.winemanager.entity.Wine;

public interface WineRepository extends JpaRepository<Wine, Integer> {

}
