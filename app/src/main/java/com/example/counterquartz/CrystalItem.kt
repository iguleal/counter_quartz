package com.example.counterquartz

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.counterquartz.model.Crystals
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class CrystalItem(
    private val crystal: Crystals,
    private val calculate: Calculate
    ) : Item<CrystalItem.CrystalViewHolder>() {

    class CrystalViewHolder(view: View) : GroupieViewHolder(view)

    override fun createViewHolder(itemView: View) = CrystalViewHolder(itemView)

    override fun getLayout() = R.layout.item_crystals

    override fun bind(viewHolder: CrystalViewHolder, position: Int) {

        val crystalValue = viewHolder.itemView.findViewById<TextView>(R.id.txt_crystal_value)
        val crystalImage = viewHolder.itemView.findViewById<ImageView>(R.id.img_crystal_icon)
        val btnMinus = viewHolder.itemView.findViewById<ImageView>(R.id.img_minus)
        val qtdCrystals = viewHolder.itemView.findViewById<TextView>(R.id.txt_crystals)
        val btnPlus = viewHolder.itemView.findViewById<ImageView>(R.id.img_plus)

        crystalImage.setImageResource(crystal.img)
        crystalValue.text = crystal.value

        btnMinus.setOnClickListener {
            var crystals = viewHolder.itemView.findViewById<TextView>(R.id.txt_crystals).text.toString().toInt()
            crystals -= 1
            qtdCrystals.text = crystals.toString()

            val value = viewHolder.itemView.findViewById<TextView>(R.id.txt_crystal_value).text.toString().toInt()
            calculate.calculate(value, false)
        }

        btnPlus.setOnClickListener {
            var crystals = viewHolder.itemView.findViewById<TextView>(R.id.txt_crystals).text.toString().toInt()
            crystals += 1
            qtdCrystals.text = crystals.toString()

            val value = viewHolder.itemView.findViewById<TextView>(R.id.txt_crystal_value).text.toString().toInt()
            calculate.calculate(value, true)
        }

    }
}