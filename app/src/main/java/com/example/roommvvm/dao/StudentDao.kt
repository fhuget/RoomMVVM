package com.example.roommvvm.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roommvvm.entity.Student

@Dao //sebuah interface dimana semua query ditempatkan
interface StudentDao {
    @Query("Select * from student") //untuk menampilkan semua data "student"
    fun getAll(): List<Student>

    @Insert //untuk memasukkan data "student"
    fun insertStudent(item: Student)
}