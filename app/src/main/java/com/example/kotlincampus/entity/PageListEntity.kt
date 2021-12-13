package com.example.kotlincampus.entity

data class PageListEntity(
    val dataList: List<PageDate>,
    val pageNum: Int,
    val pageSize: Int,
    val totalCount: Int,
    val totalPage: Int
)