package com.example.counterquartz

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.counterquartz.model.Crystals
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.xwray.groupie.GroupieAdapter

class CalculateActivity : AppCompatActivity(), Calculate {

    private var point: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)

        val rv: RecyclerView = findViewById(R.id.rv_crystal)
        rv.layoutManager = LinearLayoutManager(this)
        val adapter = GroupieAdapter()
        rv.adapter = adapter

        adapter.add(CrystalItem(Crystals("2", R.drawable.ic_refresh), this))
        adapter.add(CrystalItem(Crystals("3", R.drawable.ic_refresh), this))
        adapter.add(CrystalItem(Crystals("4", R.drawable.ic_refresh), this))
        adapter.add(CrystalItem(Crystals("5", R.drawable.ic_refresh), this))
        adapter.add(CrystalItem(Crystals("7", R.drawable.ic_refresh), this))
        adapter.add(CrystalItem(Crystals("9", R.drawable.ic_refresh), this))
        adapter.add(CrystalItem(Crystals("-3", R.drawable.ic_refresh), this))

        val name: EditText = findViewById(R.id.edit_player_name)
        val fabDone: FloatingActionButton = findViewById(R.id.fab_done)

        fabDone.setOnClickListener {
            setResult(100, Intent()
                .putExtra("name", name.text.toString())
                .putExtra("point", point))
            finish()
        }
    }

    override fun calculate(value: Int, isPlus: Boolean) {

        if (isPlus){
            point += value
        } else {
            point -= value
        }

    }

}