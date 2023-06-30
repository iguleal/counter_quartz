package com.example.counterquartz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.counterquartz.databinding.ActivityMainBinding
import com.example.counterquartz.model.Player
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.xwray.groupie.GroupieAdapter

class MainActivity : AppCompatActivity() {

    companion object{
        const val NAME = "name"
        const val POINT = "point"
        const val RESULT_CODE = 100
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMain.layoutManager = LinearLayoutManager(this)
        val adapter = GroupieAdapter()
        binding.rvMain.adapter = adapter

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if (result.resultCode == RESULT_CODE){
                val name = (result.data?.getStringExtra(NAME))!!
                val point = (result.data?.getIntExtra(POINT, 0))!!
                adapter.add(PlayerItem(Player(name, point)))
            }
        }

        binding.fabAdd.setOnClickListener {
            val i = Intent(this,CalculateActivity::class.java)
            launcher.launch(i)
        }

        binding.imgRefresh.setOnClickListener {
            recreate()
        }

    }
}