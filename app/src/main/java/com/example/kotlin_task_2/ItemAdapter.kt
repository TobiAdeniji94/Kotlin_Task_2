package com.example.kotlin_task_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item_view.view.*

class ItemAdapter (var shopItems : ArrayList<Items>, var clickListener: onShopItemClickListener) : RecyclerView.Adapter<ItemViewHolder> () {
    override fun getItemCount(): Int {
        return shopItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        lateinit var ItemViewHolder : ItemViewHolder
        ItemViewHolder = ItemViewHolder(LayoutInflater.from(parent.context). inflate(R.layout.layout_item_view,parent,false))
        return ItemViewHolder
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
    //        holder.itemName?.text = shopItems.get(position).name
      //      holder.itemDescription?.text = shopItems.get(position).description
        //    holder.itemLogo.setImageResource(shopItems.get(position).logo)

        holder.initialize(shopItems.get(position), clickListener)
    }

}

class ItemViewHolder (itemView:View) : RecyclerView.ViewHolder(itemView){
    var itemName = itemView.itemname
    var itemDescription = itemView.itemdescription
    var itemLogo = itemView.itemlogo

    fun initialize (item: Items, action: onShopItemClickListener) {
        itemName.text = item.name
        itemDescription.text = item.description
        itemLogo.setImageResource(item.logo)

        itemView.setOnClickListener{
            action.onItemClick(item, adapterPosition)
        }

    }
}

interface onShopItemClickListener {
    fun onItemClick(item: Items, position: Int)
}