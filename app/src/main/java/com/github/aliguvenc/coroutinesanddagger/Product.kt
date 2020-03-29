package com.github.aliguvenc.coroutinesanddagger

data class Product(
    val id: Int,
    val name: String,
    val displayName: String,
    val parentCategoryId: Int
)