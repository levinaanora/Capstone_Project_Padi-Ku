package com.example.capstoneprojectpadiku.artikel

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.capstoneprojectpadiku.R
import kotlinx.android.synthetic.main.item_with_desc.view.*
import kotlinx.android.synthetic.main.item_with_image.view.*

private const val POST_TYPE_DESC: Int = 0
private const val POST_TYPE_IMAGE: Int = 1

class PostListAdapter(var postListitems: List<PostModel>, val clickListener: (PostModel) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

//    private lateinit var activity: Activity

//   constructor(activity: Activity):this(){
//       this.activity = activity
//   }

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
            itemView.image_post_title.text = postModel.Judul
            itemView.desc_post_desc1.text = postModel.Headline
            Glide.with(itemView.context).load(postModel.Image).into(itemView.image_post_image)
            itemView.image_post_image.clipToOutline = true
            itemView.setOnClickListener{
                clickListener(postModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == POST_TYPE_DESC){
            val view =LayoutInflater.from(parent.context).inflate(R.layout.item_with_desc, parent, false)
            return DescViewHolder(view)
        }else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_with_image, parent, false)
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
        return if(postListitems[position].post_type == 1L){
            POST_TYPE_IMAGE
        }else{
            POST_TYPE_DESC
        }
    }

}