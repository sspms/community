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
    String disctrict
    @Column(unique = true, nullable = false)
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
    @ManyToOne
    YellowPage yellowPage
}
