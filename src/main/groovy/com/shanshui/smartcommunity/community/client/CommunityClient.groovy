package com.shanshui.smartcommunity.community.client

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by I336253 on 12/27/2017.
 */
@FeignClient("community")
public interface CommunityClient {
    
    @RequestMapping(method = RequestMethod.GET)
    def get()

    @RequestMapping(value = '/{id}', method = [RequestMethod.GET])
    def get(@PathVariable('id') Long id)

    @RequestMapping(value = '/{id}/building/{bid}', method = RequestMethod.GET)
    @ResponseBody
    def getBuilding(@PathVariable('id') Long id, @PathVariable('bid') String bid)

    @RequestMapping(value = '/{id}/building', method = RequestMethod.GET)
    @ResponseBody
    def getBuilding(@PathVariable('id') Long id)

    @RequestMapping(value = '/{id}/building/{bid}/household', method = RequestMethod.GET)
    @ResponseBody
    def getHousehold(@PathVariable('id') Long id, @PathVariable('bid') String bid)

    @RequestMapping(value = '/{id}/building/{bid}/household/{hid}', method = RequestMethod.GET)
    @ResponseBody
    def getHousehold(@PathVariable('id') Long id, @PathVariable('bid') String bid, @PathVariable('hid') String hid)

    @RequestMapping(value = '/{id}/household', method = RequestMethod.GET)
    @ResponseBody
    def getHousehold(@PathVariable('id') Long id)

}