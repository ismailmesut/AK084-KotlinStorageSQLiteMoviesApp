package com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.adapter.CategoryRecyclerViewAdapter
import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.dao.CategoriesDao
import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.database.DatabaseCopyHelper
import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.database.DatabaseHelper
import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.databinding.ActivityMainScreenBinding
import com.ismailmesutmujde.kotlinstoragesqlitemoviesapp.model.Categories


class MainScreenActivity : AppCompatActivity() {

    private lateinit var bindingMainScreen : ActivityMainScreenBinding

    private lateinit var categoryList:ArrayList<Categories>
    private lateinit var adapterCategory:CategoryRecyclerViewAdapter
    private lateinit var dbh:DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainScreen = ActivityMainScreenBinding.inflate(layoutInflater)
        val view = bindingMainScreen.root
        setContentView(view)

        copyDatabase()

        bindingMainScreen.toolbarCategory.title = "Categories"
        setSupportActionBar(bindingMainScreen.toolbarCategory)

        bindingMainScreen.recyclerViewCategory.setHasFixedSize(true)
        bindingMainScreen.recyclerViewCategory.layoutManager = LinearLayoutManager(this)

        /*
        categoryList = ArrayList()

        val c1 = Categories(1,"Science Fiction")
        val c2 = Categories(2,"Drama")
        val c3 = Categories(3,"Action")
        val c4 = Categories(4,"Adventure")
        val c5 = Categories(5,"Fantastic")
        val c6 = Categories(6,"Romantic")
        val c7 = Categories(1,"Comedy")
        val c8 = Categories(2,"Thriller")
        val c9 = Categories(1,"Horror")
        val c10 = Categories(2,"War")

        categoryList.add(c1)
        categoryList.add(c2)
        categoryList.add(c3)
        categoryList.add(c4)
        categoryList.add(c5)
        categoryList.add(c6)
        categoryList.add(c7)
        categoryList.add(c8)
        categoryList.add(c9)
        categoryList.add(c10)

         */

        dbh = DatabaseHelper(this)
        categoryList = CategoriesDao().allCategories(dbh)


        adapterCategory = CategoryRecyclerViewAdapter(this, categoryList)
        bindingMainScreen.recyclerViewCategory.adapter = adapterCategory

    }

    fun copyDatabase() {
        val copyHelper = DatabaseCopyHelper(this)
        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        } catch (e:Exception) {
            e.printStackTrace()
        }
    }
}