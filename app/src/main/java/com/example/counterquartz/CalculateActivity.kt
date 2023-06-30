package com.example.counterquartz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.counterquartz.databinding.ActivityCalculateBinding
import com.example.counterquartz.model.Crystals
import com.xwray.groupie.GroupieAdapter

class CalculateActivity : AppCompatActivity(), Calculate {

    private lateinit var binding: ActivityCalculateBinding
    private var point: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCrystal.layoutManager = LinearLayoutManager(this)
        val adapter = GroupieAdapter()
        binding.rvCrystal.adapter = adapter

        adapter.add(CrystalItem(Crystals("2", R.drawable.ic_quartz, R.drawable.shadow_quartz), this))
        adapter.add(CrystalItem(Crystals("3", R.drawable.ic_rubelita, R.drawable.shadow_rubelita), this))
        adapter.add(CrystalItem(Crystals("4", R.drawable.ic_esmeralda,R.drawable.shadow_esmeralda), this))
        adapter.add(CrystalItem(Crystals("5", R.drawable.ic_safira,R.drawable.shadow_safira), this))
        adapter.add(CrystalItem(Crystals("7", R.drawable.ic_rubi,R.drawable.shadow_rubi), this))
        adapter.add(CrystalItem(Crystals("9", R.drawable.ic_ambar,R.drawable.shadow_ambar), this))
        adapter.add(CrystalItem(Crystals("-3", R.drawable.ic_autunita,R.drawable.shadow_autunita), this))


        binding.fabDone.setOnClickListener {
            if (binding.checkbox.isChecked){
                point += -5
            }

            setResult(
                MainActivity.RESULT_CODE, Intent()
                    .putExtra(MainActivity.NAME, binding.editPlayerName.text.toString())
                    .putExtra(MainActivity.POINT, point)
            )
            finish()
        }

        binding.constraintContainer.setOnClickListener {
            hideKeyboard()
        }

        binding.imgClose.setOnClickListener {
            finish()
        }
    }

    override fun calculate(value: Int, bonus: Int) {
        point += (value + bonus)
    }

    override fun hideKeyboard() {
        val keyboardService = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        keyboardService.hideSoftInputFromWindow(this.currentFocus?.windowToken, 0)
    }
}