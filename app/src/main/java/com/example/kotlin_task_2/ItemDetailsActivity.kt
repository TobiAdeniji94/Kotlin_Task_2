package com.example.kotlin_task_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.kotlin_task_2.databinding.ActivityItemDetailsBinding
import kotlinx.android.synthetic.main.activity_item_details.*

class ItemDetailsActivity : AppCompatActivity() {

    lateinit var binding : ActivityItemDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item_details)

        item_name.text = getIntent().getStringExtra("ITEMNAME")
        item_description.text = getIntent().getStringExtra("ITEMDESCRIPTION")
        item_image.setImageResource(getIntent().getStringExtra("ITEMLOGO").toInt())
    }
}
