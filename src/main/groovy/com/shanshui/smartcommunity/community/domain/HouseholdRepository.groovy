package com.shanshui.smartcommunity.community.domain

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

/**
 * Created by I336253 on 11/19/2017.
 */
public interface HouseholdRepository extends CrudRepository<Household, Long> {

    @Query('select h from Household h where h.community = $1 and h.building = $2 and h.number = $3')
    Household find(long communityId, long buildingId, String number)

    @Query('select h from Household h where h.community = $1 and h.building = $2')
    List<Household> findAll(long communityId, long buildingId)

    @Query('select h from Household h where h.owner = $1')
    List<Household> findByUser(long userId)

    @Query('select h from Household h where h.community = $1')
    List<Household> findAll(long community)

    @Query('select h from Household h where h.community = $1 and h.owner is null')
    List<Household> findNotCertified(long communityId)

    @Modifying
    @Query('update Household h set h.owner = $2 where h.id = $1')
    void updateUser(long id, long userId)

    @Modifying
    @Query('update Household h set h.owner = $2 where h.community = $1 and h.building = $2 and h.number = $3')
    void updateUser(long community, long building, String number, long userId)
}