package com.shanshui.smartcommunity.community.domain

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

/**
 * Created by I336253 on 11/19/2017.
 */
public interface CommunityRepository extends CrudRepository<Community, Long> {

    @Query('select c from Community c where c.name = ?1')
    Community findByName(String name)

    @Query('select c from Community c where c.location = ?1')
    Community findByLocation(String location)

    @Query('select c from Community c where c.name like ?1')
    List<Community> findPattern(String namePattern)

    @Query('select c from Community c where c.province= ?1 and c.city = ?2 and c.district = ?3')
    List<Community> findAll(String province, String city, String district)
}