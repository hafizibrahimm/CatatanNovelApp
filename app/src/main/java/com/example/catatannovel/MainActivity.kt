package com.example.catatannovel

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var rvNovel: RecyclerView
    private val list = ArrayList<Novel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvNovel = findViewById(R.id.rv_novel)
        rvNovel.setHasFixedSize(true)

        list.addAll(getListNovel())
        showRecyclerList()

        val aboutButton: ImageButton = findViewById(R.id.btn_about)
        aboutButton.setOnClickListener {
            val intent = Intent(this, About::class.java)
            startActivity(intent)
        }
    }

    private fun getListNovel(): ArrayList<Novel> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataAuthor = resources.getStringArray(R.array.data_author)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listNovel = ArrayList<Novel>()
        for (i in dataName.indices) {
            val novel = Novel(dataName[i], dataAuthor[i], dataDescription[i], dataPhoto[i])
            listNovel.add(novel)
        }
        return listNovel
    }

    private fun showRecyclerList() {
        rvNovel.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListNovelAdapter(list)
        rvNovel.adapter = listHeroAdapter
    }
}
