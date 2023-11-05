package com.example.codewithmazn_recyclerview_drag_and_drop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerAdapter

    private var countryList = mutableListOf<String>()
    private var displayList = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countryList.add("Австралийский Союз")
        countryList.add("Австрия")
        countryList.add("Азербайджан")
        countryList.add("Аландские острова")
        countryList.add("Албания")
        countryList.add("Алжир")
        countryList.add("Американские Виргинские острова")
        countryList.add("Американское Самоа")
        countryList.add("Ангилья")
        countryList.add("Англия")
        countryList.add("Ангола")
        countryList.add("Андорра")
        countryList.add("Антарктида")
        countryList.add("Израиль")
        countryList.add("Индия")
        countryList.add("Иордания")
        countryList.add("Иран")
        countryList.add("Ирландия")
        countryList.add("Исландия")
        countryList.add("Испания")
        countryList.add("Италия")
        countryList.add("Маврикий")
        countryList.add("Мавритания")
        countryList.add("Мадагаскар")
        countryList.add("Майотта")
        countryList.add("Макао")
        countryList.add("Македония")
        countryList.add("Малави")
        countryList.add("Малайзия")
        countryList.add("Мали")
        countryList.add("Мальдивы")
        countryList.add("Мальта")
        countryList.add("Марокко")

        displayList.addAll(countryList)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerAdapter = RecyclerAdapter(displayList)

        recyclerView.adapter = recyclerAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        var item: MenuItem = menu!!.findItem(R.id.action_search)

        if (item != null) {
            var searchView = item.actionView as SearchView

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText!!.isEmpty()) {
                        displayList.clear()

                        var search = newText.toLowerCase(Locale.getDefault())

                        for (country in countryList) {
                            if (country.toLowerCase(Locale.getDefault()).contains(search)) {
                                displayList.add(country)
                            }
                            recyclerView.adapter!!.notifyDataSetChanged()
                        }
                    } else {
                        displayList.clear()
                        displayList.addAll(countryList)
                        recyclerView.adapter!!.notifyDataSetChanged()
                    }

                    return true
                }

            })
        }
        return super.onCreateOptionsMenu(menu)
    }
}