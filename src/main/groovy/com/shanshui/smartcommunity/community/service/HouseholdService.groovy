package com.shanshui.smartcommunity.community.service

import com.shanshui.smartcommunity.community.domain.Building
import com.shanshui.smartcommunity.community.domain.Community
import com.shanshui.smartcommunity.community.domain.Household
import com.shanshui.smartcommunity.community.domain.HouseholdRepository
import com.shanshui.smartcommunity.user.domain.User
import com.shanshui.smartcommunity.user.service.DynamicCodeService
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
class HouseholdService {

    @Autowired
    HouseholdRepository householdRepository

    @Autowired
    CommunityService communityService

    def certifyOwner(Household houseHold, String userId) {
        householdRepository.updateUser(houseHold.id, userId)
        LOGGER.info("$houseHold owner has been updated with user ID $userId")
        householdRepository.findOne(houseHold.id)?.owner.id = userId
    }

    List<Household> getAllHouseholds(Building building) {
        householdRepository.findAll(building.community.id, building.id)
    }

    List<Household> getAllHouseholds(Community community) {
        householdRepository.findAll(community.id)
    }

    List<Household> getAllHouseholds(String community) {
        def id = communityService.find(community)?.id
        if (id) {
            householdRepository.findAll(community.id)
        }
    }

    List<Household> getAllHouseholds(User user) {
        householdRepository.findByUser(user.id)
    }

    List<Community> getCommunities(User user) {
        List<Household> households = householdRepository.findByUser(user.id)
        List<Community> communities = []
        households.each { household ->
            communities << household.community
        }
        return communities
    }

    List<Household> getNotCertified(Community community) {
        householdRepository.findNotCertified(community.id)
    }
    //List<Household>
    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicCodeService.class)
}
