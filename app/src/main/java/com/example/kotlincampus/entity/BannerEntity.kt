package com.example.kotlincampus.entity

data class BannerEntity(
    val active: Boolean,
    val createAt: String,
    val createUname: String,
    val createUserId: Int,
    val hrefTargetType: String,
    val hrefUrl: String,
    val id: Int,
    val location: String,
    val modifyAt: String,
    val organizationUid: String,
    val pictureUrl: String,
    val publishDt: String,
    val seq: Int,
    val title: String
)