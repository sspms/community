package com.shanshui.smartcommunity.community.service

import com.shanshui.smartcommunity.community.domain.Community
import com.shanshui.smartcommunity.community.domain.CommunityRepository
import com.shanshui.smartcommunity.user.service.DynamicCodeService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by I336253 on 12/3/2017.
 */
@Service
class CommunityService {

    @Autowired
    CommunityRepository communityRepository

    Community find(String name) {
        communityRepository.findByName(name)
    }

    def add(Community community) {
        find(community.name) ? null : communityRepository.save(community)
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicCodeService.class)
}
