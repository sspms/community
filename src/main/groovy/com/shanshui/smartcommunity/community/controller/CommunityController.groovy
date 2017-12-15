package com.shanshui.smartcommunity.community.controller

import com.shanshui.smartcommunity.community.domain.Building
import com.shanshui.smartcommunity.community.domain.Community
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

    @Autowired
    CommunityService communityService
    @Autowired
    BuildingService buildingService
    @Autowired
    HouseholdService householdService

    @RequestMapping(method = RequestMethod.POST)
    def put(@RequestBody Community community) {
        communityService.communityRepository.save(community)
    }

    @RequestMapping(method = RequestMethod.GET)
    def get() {
        communityService.communityRepository.findAll()
    }
    /**
     * internal used for services
     * @param id
     * @param token
     * @return
     */
    @RequestMapping(value = '/{id}', method = [RequestMethod.GET])
    def get(@PathVariable('id') Long id) {
        id ? communityService.communityRepository.findOne(id) : null
    }

    @RequestMapping(value = '/{id}/building/{bid}', method = RequestMethod.GET)
    @ResponseBody
    def getBuilding(@PathVariable('id') Long id, @PathVariable('bid') Long bid) {
        id && bid ? buildingService.find(id, bid.toString()) : null
    }

    @RequestMapping(value = '/{id}/building', method = RequestMethod.POST)
    @ResponseBody
    def putBuilding(@PathVariable('id') Long id, @RequestBody Building building) {
        id && building ? buildingService.buildingRepository.save(building) : null
    }

    @RequestMapping(value = '/{id}/building', method = RequestMethod.GET)
    @ResponseBody
    def getBuilding(@PathVariable('id') Long id) {
        id ? buildingService.buildingRepository.findAll(id): null
    }

    @RequestMapping(value = '/{id}/building/{bid}/household', method = RequestMethod.GET)
    @ResponseBody
    def getHousehold(@PathVariable('id') Long id, @PathVariable('bid') Long bid) {
        def building = id && bid ? getBuilding(id, bid) : null
        building ? householdService.getAllHouseholds(building) : null
    }

    @RequestMapping(value = '/{id}/building/{bid}/household/{hid}', method = RequestMethod.GET)
    @ResponseBody
    def getHousehold(@PathVariable('id') Long id, @PathVariable('bid') Long bid, @PathVariable('hid') long hid) {
        hid ? householdService.householdRepository.findOne(hid) : null
    }

    @RequestMapping(value = '/{id}/building/{bid}/household/{hid}', method = RequestMethod.POST)
    def certify(@PathVariable('id') Long id, @PathVariable('bid') Long bid, @PathVariable('hid') long hid, User user) {
        def household = getHousehold(id, bid, hid)
        householdService.certifyOwner(household, user)
    }

    public static void main(String[] args) {
        SpringApplication.run CommunityController.class, args
    }
}
