package com.xk.eyepetizer.mvp.model.bean

import java.io.Serializable


data class Category(val id: Long, val name: String, val description: String, val bgPicture: String, val bgColor: String, val headerImage: String) : Serializable
