package com.dj.spacex.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.dj.spacex.R
import com.dj.spacex.databinding.HomeSingleItemBinding


class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var menuList: List<String> = emptyList()

    class ViewHolder(val binding: HomeSingleItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: String, imageId: Int) {
            binding.apply {
                binding.menuItem = item
                binding.imageId = imageId
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: HomeSingleItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.home_single_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        val item = menuList[position]
        val imageId = when (item) {


            "Rockets" -> R.mipmap.ic_launcher

            else -> null
        }


        if (imageId != null) {
            holder.bindView(item, imageId)
        }



        holder.itemView.setOnClickListener(
            when (item) {

                "Rockets" -> Navigation.createNavigateOnClickListener(R.id.nav_rocket)

                else -> null
            }

        )
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addMenuItemToList(data: List<String>) {
        menuList = data
        notifyDataSetChanged()

    }

}