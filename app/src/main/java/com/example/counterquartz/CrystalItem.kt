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
        viewHolder.itemView.findViewById<TextView>(R.id.txt_crystal_value).text = crystal.value
        viewHolder.itemView.findViewById<ImageView>(R.id.img_crystal_icon).setImageResource(crystal.img)

        viewHolder.itemView.findViewById<ImageView>(R.id.img_minus).setOnClickListener {
           var crystals =  viewHolder.itemView.findViewById<TextView>(R.id.txt_crystals).text.toString().toInt()
            crystals -= 1
            viewHolder.itemView.findViewById<TextView>(R.id.txt_crystals).text = crystals.toString()
            calculate.calculate(crystals)
        }

        viewHolder.itemView.findViewById<ImageView>(R.id.img_plus).setOnClickListener {
            var crystals =  viewHolder.itemView.findViewById<TextView>(R.id.txt_crystals).text.toString().toInt()
            crystals += 1
            viewHolder.itemView.findViewById<TextView>(R.id.txt_crystals).text = crystals.toString()
            calculate.calculate(crystals)
        }


    }
}