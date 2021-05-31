package com.example.kraskrit.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kraskrit.data.models.MainData
import com.example.kraskrit.databinding.ItemMainBinding

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var model:List<MainData> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    private lateinit var itemClick: (MainData) -> Unit

    fun setItemClick(itemClick: (model: MainData) -> Unit) {
        this.itemClick = itemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        var binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainViewHolder(binding)
    }

    override fun getItemCount(): Int = model.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(model[position])
    }

    inner class MainViewHolder(binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root){
        var name = binding.tvMain
        var image = binding.ivMain
        var detail = binding.tvAbout
        fun bind(mainData: MainData){
            name.text = mainData.name
            detail.text = mainData.detail
            itemView.setOnClickListener {
                itemClick.invoke(mainData)
            }
            Glide.with(itemView.context).load(getImage(mainData.imageName)).optionalCenterCrop().into(image)
        }
        fun getImage(imageName: String?): Int {
            return itemView.resources.getIdentifier(imageName, "drawable", itemView.context.packageName)
        }
    }
}