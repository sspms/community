package com.shanshui.smartcommunity.community.domain

import javax.persistence.*

@Entity
class Community implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    @Column(unique = true, nullable = false)
    String name
    String city
    String province
    String district
    @Column(unique = true, nullable = true)
    String location
    String developer
    //PropertyCompany propertyMngm
    //NeighborhoodCommittee neighborhoodCommittee
    Date completionDate
    double greenRate
    double capacityRate
    int parkingLotNumber
    int buildingNumber
    int houseHoldNumber
    String layoutLink
    String description
    @ManyToOne(fetch = FetchType.LAZY)
    YellowPage yellowPage
}
