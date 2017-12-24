package com.shanshui.smartcommunity.community.controller

import com.shanshui.smartcommunity.community.domain.Building
import com.shanshui.smartcommunity.community.domain.Community
import com.shanshui.smartcommunity.community.domain.Household
import com.shanshui.smartcommunity.community.service.BuildingService
import com.shanshui.smartcommunity.community.service.CommunityService
import com.shanshui.smartcommunity.community.service.HouseholdService
import com.shanshui.smartcommunity.user.domain.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.cache.annotation.EnableCaching
import org.springframework.web.bind.annotation.*

/**
 * Created by I336253 on 11/19/2017.
 */
@RestController
@RequestMapping('/community')
@EnableAutoConfiguration
@EnableCaching
class CommunityController {

    //@Autowired
    //CommunityService communityService
    //@Autowired
    //BuildingService buildingService
    @Autowired
    HouseholdService householdService

    @RequestMapping(method = RequestMethod.POST)
    def put(@RequestBody Community community) {
        householdService.communityService.communityRepository.save(community)
    }

    @RequestMapping(method = RequestMethod.GET)
    def get() {
        householdService.communityService.communityRepository.findAll()
    }
    /**
     * internal used for services
     * @param id
     * @param token
     * @return
     */
    @RequestMapping(value = '/{id}', method = [RequestMethod.GET])
    def get(@PathVariable('id') Long id) {
        id ? householdService.communityService.communityRepository.findOne(id) : null
    }

    @RequestMapping(value = '/{id}/building/{bid}', method = RequestMethod.GET)
    @ResponseBody
    def getBuilding(@PathVariable('id') Long id, @PathVariable('bid') String bid) {
        id && bid ? householdService.buildingService.find(id, bid) : null
    }

    @RequestMapping(value = '/{id}/building', method = RequestMethod.POST)
    @ResponseBody
    def putBuilding(@PathVariable('id') Long id, @RequestBody Building building) {
        id && building ? householdService.buildingService.add(id, building) : null
    }

    @RequestMapping(value = '/{id}/building', method = RequestMethod.GET)
    @ResponseBody
    def getBuilding(@PathVariable('id') Long id) {
        id ? householdService.buildingService.buildingRepository.findAll(id) : null
    }

    @RequestMapping(value = '/{id}/building/{bid}/household', method = RequestMethod.POST)
    @ResponseBody
    def putHousehold(@PathVariable('id') Long id, @PathVariable('bid') String bid, @RequestBody Household household) {
        def building = id && bid ? getBuilding(id, bid) : null
        building ? householdService.householdRepository.save(household) : null
    }

    @RequestMapping(value = '/{id}/building/{bid}/household', method = RequestMethod.GET)
    @ResponseBody
    def getHousehold(@PathVariable('id') Long id, @PathVariable('bid') String bid) {
        def building = id && bid ? getBuilding(id, bid) : null
        building ? householdService.getAllHouseholds(building) : null
    }

    @RequestMapping(value = '/{id}/building/{bid}/household/{hid}', method = RequestMethod.GET)
    @ResponseBody
    def getHousehold(@PathVariable('id') Long id, @PathVariable('bid') String bid, @PathVariable('hid') String hid) {
        id && bid && hid ? householdService.getHousehold(id, bid, hid) : null
    }

    @RequestMapping(value = '/{id}/household', method = RequestMethod.GET)
    @ResponseBody
    def getHousehold(@PathVariable('id') Long id) {
        def community = id ? get(id) : null
        community ? householdService.getAllHouseholds(community) : null
    }

    @RequestMapping(value = '/{id}/building/{bid}/household/{hid}', method = RequestMethod.POST)
    def certify(
            @PathVariable('id') Long id, @PathVariable('bid') String bid, @PathVariable('hid') String hid, User user) {
        def household = getHousehold(id, bid, hid)
        householdService.certifyOwner(household, user.id.toString())
    }

    public static void main(String[] args) {
        SpringApplication.run CommunityController.class, args
    }
}
