package com.example.capstoneprojectpadiku.Information

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.capstoneprojectpadiku.R
import kotlinx.android.synthetic.main.item_information.view.*

private const val POST_TYPE_DESC: Int = 0
private const val POST_TYPE_IMAGE: Int = 1

class InfoListAdapters(var infoListitems: List<InfoModel>, val clickListener: (InfoModel) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class DescViewholder (itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(infoModel: InfoModel, clickListener: (InfoModel) -> Unit){
            itemView.judul_info.text = infoModel.name
            itemView.txt_isi.text = infoModel.desc
            Glide.with(itemView.context).load(infoModel.image).into(itemView.img_info)
            itemView.img_info.clipToOutline = true
            itemView.setOnClickListener{
                clickListener(infoModel)
            }
        }
    }

    class ImageViewholder (itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(infoModel: InfoModel, clickListener: (InfoModel) -> Unit){
            itemView.judul_info.text = infoModel.name
            itemView.txt_isi.text = infoModel.desc
            Glide.with(itemView.context).load(infoModel.image).into(itemView.img_info)
            itemView.img_info.clipToOutline = true
            itemView.setOnClickListener{
                clickListener(infoModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == POST_TYPE_DESC){
            val view =LayoutInflater.from(parent.context).inflate(R.layout.item_information, parent, false)
            return DescViewholder(view)
        }else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_information, parent, false)
            return ImageViewholder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == POST_TYPE_DESC){
            (holder as DescViewholder).bind(infoListitems[position], clickListener)
        }else{
            (holder as ImageViewholder).bind(infoListitems[position], clickListener)
        }
    }

    override fun getItemCount(): Int {
        return infoListitems.size
    }

    override fun getItemViewType(position: Int): Int {
        return if(infoListitems[position].post_type == 0L){
            POST_TYPE_IMAGE
        }else{
            POST_TYPE_DESC
        }
    }
}