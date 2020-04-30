package com.example.roommvvm.viewmodel

import android.app.Application
import android.graphics.Movie
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.roommvvm.data.AppDatabase
import com.example.roommvvm.entity.Student
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber

// ViewModel yaitu adalah class yang bertanggung jawab untuk menyiapkan dan mengelola data untuk suatu activity atau fragment

class NewStudentViewModel(application: Application) : AndroidViewModel(application) {
    private val mDb: AppDatabase? = AppDatabase.getInstance(application)
    private val allStudent = MutableLiveData<List<Student>>()

    // untuk melakukan insert pada database

    fun storeMovie(title: String) {

        val student = Student()
        student.name = title

        GlobalScope.launch {
            mDb?.studentDao()?.insertStudent(student)
        }
    }

    //    untuk menerima semua data dari database

    fun retrieveStudent(): LiveData<List<Student>> {

        GlobalScope.launch {
            val list = mDb?.studentDao()?.getAll()

            Timber.i("Data yang ada sejumlah {${list?.size}}")
            allStudent.postValue(list)
        }

        return allStudent
    }
}