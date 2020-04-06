package com.example.kotlin_task_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_task_2.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), onShopItemClickListener {

    lateinit var binding: ActivityMainBinding
    lateinit var itemlist: ArrayList<Items>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        itemlist = ArrayList()
        addItems()

        shopRecycler.layoutManager = LinearLayoutManager(this)
        shopRecycler.addItemDecoration(DividerItemDecoration(this,1))
        shopRecycler.adapter = ItemAdapter(itemlist, this)
    }

    fun addItems(){
        itemlist.add(Items(name = "Dangote Sugar", description = "Vitamin A Fortified Refined Granulated Sugar 1kg (2 Packs)", logo = R.drawable.dangote_logo))
        itemlist.add(Items(name = "Nido Milk", description = "Powdered Milk 350g", logo = R.drawable.nido_logo))
        itemlist.add(Items(name = "Dettol Antiseptic", description = "Antiseptic Liquid Disinfectant 1 Litre", logo = R.drawable.dettol_logo))
        itemlist.add(Items(name = "Pepsi Soft Drink", description = "Plastic Bottle Drink", logo = R.drawable.pepsi_logo))
        itemlist.add(Items(name = "Gap Kids Clothing", description = "Toddler Sets Cotton Outfit 1-3 Years", logo = R.drawable.gapkids_logo))
        itemlist.add(Items(name = "Adidas Footwear", description = "Unisex Training Shoes", logo = R.drawable.adidas_logo))
    }

    override fun onItemClick(item: Items, position: Int) {
//        Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ItemDetailsActivity::class.java)
        intent.putExtra("ITEMNAME", item.name)
        intent.putExtra("ITEMDESCRIPTION", item.description)
        intent.putExtra("ITEMLOGO", item.logo.toString())
        startActivity(intent)
    }
}


