package com.example.counterquartz

import android.graphics.drawable.LayerDrawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
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
        val crystalsQtd = viewHolder.itemView.findViewById<TextView>(R.id.txt_crystals)
        val btnPlus = viewHolder.itemView.findViewById<ImageView>(R.id.img_plus)
        val container = viewHolder.itemView.findViewById<ConstraintLayout>(R.id.container)

        container.setBackgroundResource(crystal.bgColor)

        crystalImage.setImageResource(crystal.img)
        crystalValue.text = crystal.value

        btnMinus.setOnClickListener {
            var crystals = crystalsQtd.text.toString().toInt()
            crystals -= 1
            crystalsQtd.text = crystals.toString()

            val value = crystalValue.text.toString().toInt()

            when (crystals) {
                2 -> calculate.calculate(-value, -3)
                3 -> calculate.calculate(-value, 3 - 6)
                4 -> calculate.calculate(-value, 6 - 10)
                else -> calculate.calculate(-value)
            }
        }

        btnPlus.setOnClickListener {
            var crystals = crystalsQtd.text.toString().toInt()
            crystals += 1
            crystalsQtd.text = crystals.toString()

            val value = crystalValue.text.toString().toInt()

            when (crystals) {
                3 -> calculate.calculate(value, 3)
                4 -> calculate.calculate(value, 6 - 3)
                5 -> calculate.calculate(value, 10 - 6)
                else -> calculate.calculate(value)
            }
        }

    }
}