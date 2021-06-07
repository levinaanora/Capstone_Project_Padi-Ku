package com.example.capstoneprojectpadiku.artikel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.capstoneprojectpadiku.R
import kotlinx.android.synthetic.main.activity_detail_artikel.view.*
import kotlinx.android.synthetic.main.item_with_desc.view.*
import kotlinx.android.synthetic.main.item_with_image.view.*

private const val POST_TYPE_DESC: Int = 0
private const val POST_TYPE_IMAGE: Int = 1

class DetailArtikelAdapter(var postListitems: List<PostModel>, val clickListener: (PostModel) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class DescViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(postModel: PostModel, clickListener: (PostModel) -> Unit){
            itemView.desc_post_title.text = postModel.Judul
            itemView.desc_post_desc.text = postModel.Headline
            itemView.setOnClickListener{
                clickListener(postModel)
            }
        }
    }

    class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(postModel: PostModel, clickListener: (PostModel) -> Unit){
            itemView.txt_title.text = postModel.Judul
            itemView.txt_headline.text = postModel.Headline
            itemView.txt_date.text = postModel.Tanggal
            itemView.txt_penulis.text = postModel.Penulis
            itemView.txt_detail.text = postModel.Isi_artikel
            Glide.with(itemView.context).load(postModel.Image).into(itemView.image_post_image)
            itemView.image_post_image.clipToOutline = true
            itemView.setOnClickListener{
                clickListener(postModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == POST_TYPE_DESC){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_detail_artikel, parent, false)
            return DescViewHolder(view)
        }else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_detail_artikel, parent, false)
            return ImageViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == POST_TYPE_DESC){
            (holder as DescViewHolder).bind(postListitems[position], clickListener)
        }else{
            (holder as ImageViewHolder).bind(postListitems[position], clickListener)
        }
    }

    override fun getItemCount(): Int {
        return postListitems.size
    }

    override fun getItemViewType(position: Int): Int {
        return if(postListitems[position].post_type == 0L){
            POST_TYPE_IMAGE
        }else{
            POST_TYPE_DESC
        }
    }

}