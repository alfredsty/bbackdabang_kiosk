package com.example.bback

data class Product(
	val idx: Int,
	var title: String,
	var price: Int,
	var image: String,
	var count: Int = 0,
	var option: String = ""
)
