package com.shanshui.smartcommunity.community.domain

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

/**
 * Created by I336253 on 11/19/2017.
 */
public interface HouseholdRepository extends CrudRepository<Household, Long> {

    @Query('select h from Household h where h.community.id = ?1 and h.building.id = ?2 and h.number = ?3')
    Household find(long communityId, long building, String number)

    @Query('select h from Household h where h.community.id = ?1 and h.building.id = ?2')
    List<Household> findAll(long communityId, long building)

    @Query('select h from Household h where h.owner.id = ?1')
    List<Household> findByUser(long userId)

    @Query('select h from Household h where h.community.id = ?1')
    List<Household> findAll(long community)

    @Query('select h from Household h where h.community.id = ?1 and h.owner.id is null')
    List<Household> findNotCertified(long communityId)

    @Modifying
    @Query('update Household h set h.owner.id = ?2 where h.id = ?1')
    void updateUser(long id, long userId)

    @Modifying
    @Query('update Household h set h.owner = ?4 where h.community.id = ?1 and h.building.id = ?2 and h.number = ?3')
    void updateUser(long community, long building, String number, long userId)
}