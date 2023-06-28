package com.example.counterquartz

import android.view.View
import android.widget.TextView
import com.example.counterquartz.model.Player
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class PlayerItem(private val player: Player): Item<PlayerItem.PlayerViewHolder>() {

class PlayerViewHolder(view:View):GroupieViewHolder(view)

    override fun createViewHolder(itemView: View) = PlayerViewHolder(itemView)

    override fun bind(viewHolder: PlayerViewHolder, position: Int) {
        viewHolder.itemView.findViewById<TextView>(R.id.txt_player_name).text = player.name
        viewHolder.itemView.findViewById<TextView>(R.id.txt_player_points).text = player.points.toString()
    }

    override fun getLayout() = R.layout.item_player
}