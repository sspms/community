package com.shanshui.smartcommunity.community.service

import com.shanshui.smartcommunity.community.domain.Building
import com.shanshui.smartcommunity.community.domain.BuildingRepository
import com.shanshui.smartcommunity.community.domain.BuildingType
import com.shanshui.smartcommunity.community.domain.Community
import com.shanshui.smartcommunity.user.domain.User
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.EnableCaching
import org.springframework.stereotype.Service

/**
 * Created by I336253 on 12/3/2017.
 */
@Service
@EnableCaching
class BuildingService {
    @Autowired
    BuildingRepository buildingRepository

    List<Building> findAll(Community community) {
        buildingRepository.findAll(community.id)
    }

    Building find(long communityId, String number) {
        buildingRepository.find(communityId, number)
    }

    List<Building> findAllByType(Community community, BuildingType type) {
        buildingRepository.findAllByType(community.id, type.toString())
    }

    List<Building> findAll(User leader) {
        buildingRepository.findAll(leader.id)
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(BuildingService.class)
}
