package com.shanshui.smartcommunity.community.domain

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

/**
 * Created by I336253 on 11/19/2017.
 */
public interface YelloPageRepository extends CrudRepository<YellowPage, Long> {
    @Query('select yp from YellowPage yp where yp.district = $1')
    List<YellowPage> findAll(String district)
}