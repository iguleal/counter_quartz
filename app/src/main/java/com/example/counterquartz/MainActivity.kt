package com.example.counterquartz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.counterquartz.model.Player
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.xwray.groupie.GroupieAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd: FloatingActionButton = findViewById(R.id.fab_add)

        val rv = findViewById<RecyclerView>(R.id.rv_main)
        rv.layoutManager = LinearLayoutManager(this)
        val adapter = GroupieAdapter()
        rv.adapter = adapter

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if (result.resultCode == 100){
                val name = (result.data?.getStringExtra("ok"))!!
                val point = (result.data?.getIntExtra("point", 0))!!
                adapter.add(PlayerItem(Player(name, point)))
            }
        }

        btnAdd.setOnClickListener {
            val i = Intent(this,CalculateActivity::class.java)
            launcher.launch(i)
        }
    }
}