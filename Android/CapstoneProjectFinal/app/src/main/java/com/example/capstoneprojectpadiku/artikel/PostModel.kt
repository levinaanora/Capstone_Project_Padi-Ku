package com.example.capstoneprojectpadiku.artikel

data class PostModel(
    val Headline: String = "",
    val Image: String = "",
    val Isi_artikel: String = "",
    val Judul: String = "",
    val Penulis: String = "",
    val Tanggal: String = "",
    val post_type: Long = 0
)