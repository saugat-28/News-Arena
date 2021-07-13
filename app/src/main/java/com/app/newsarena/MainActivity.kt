package com.app.newsarena

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.newsarena.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity(), NewsItemClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val items = fetchData()
        binding.recyclerView.adapter = NewsListAdapter(items, this)

    }

    private fun fetchData(): ArrayList<String> {
        val list = ArrayList<String>()
        for (i in 0 until 100){
            list.add("Item $i")
        }
        return list
    }

    override fun onItemClicked(item: String) {
        Toast.makeText(this, "Item clicked is $item", Toast.LENGTH_LONG).show()
    }

}