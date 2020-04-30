package com.example.roommvvm.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity //memudahkan mendefinisikan tabel beserta kolomnya
data class Student (
    @PrimaryKey(autoGenerate = true) var id: Int? = null, //mendefinisikan primary key

    @ColumnInfo var name: String = "" //menginfokan kolom
)