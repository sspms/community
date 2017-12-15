package com.shanshui.smartcommunity.community.domain

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

/**
 * Created by I336253 on 11/19/2017.
 */
public interface BuildingRepository extends CrudRepository<Building, Long> {

    @Query('select b from Building b where b.community = ?1 and b.number = ?2')
    Building find(long community, String number)

    @Query('select b from Building b where b.community = ?1')
    List<Building> findAll(long community)

    @Query('select b from Building b where b.community = $1 and b.type = $2')
    List<Building> findAllByType(long community, String type)

    @Query('select b from Building b where b.leader = ?1')
    List<Building> findAll(String leader)
}