package com.example.framerlink.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "tags")
    val tags: String,

    @ColumnInfo(name = "rating")
    val rating: Double?,

    @ColumnInfo(name = "price")
    val price: Double?,

    @ColumnInfo(name = "coverUrl")
    val coverUrl: String,

    @ColumnInfo(name = "imageUrls")
    val imageUrls: List<String?>?,

    @ColumnInfo(name = "active")
    val active: Boolean,

    @ColumnInfo(name = "likes")
    val likes: Int,

    @ColumnInfo(name = "normal")
    val normal: Int,

    @ColumnInfo(name = "dislikes")
    val dislikes: Int,

    @ColumnInfo(name = "capacity")
    val capacity: String
)