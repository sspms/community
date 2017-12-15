package com.shanshui.smartcommunity.community.domain

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

/**
 * Created by I336253 on 11/19/2017.
 */
public interface PublicServiceRepository extends CrudRepository<PublicService, Long> {

    @Query('select ps from PublicService ps where ps.district = $1')
    List<PublicService> findAll(String district)
}