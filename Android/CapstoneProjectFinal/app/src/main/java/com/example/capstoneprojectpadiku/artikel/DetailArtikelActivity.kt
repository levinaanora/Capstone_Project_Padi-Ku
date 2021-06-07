package com.example.capstoneprojectpadiku.artikel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capstoneprojectpadiku.R
import kotlinx.android.synthetic.main.activity_article.*

private const val TAG: String = "HOMEPAGE_LOG"

class DetailArtikelActivity: AppCompatActivity(), (PostModel) -> Unit {

    private val firebaseRepo: FirebaseRepo = FirebaseRepo()
    private var postList: List<PostModel> = ArrayList()
    private val detailArtikelAdapter: DetailArtikelAdapter = DetailArtikelAdapter(postList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_artikel)

        if(firebaseRepo.getUser() == null) {
            firebaseRepo.creteUser().addOnCompleteListener() {
                if (it.isSuccessful) {
                    loadPostData()
                } else {
                    Log.d(TAG, "Error: ${it.exception!!.message}")
                }
            }
        }else{
            loadPostData()
        }
        firestore_list.layoutManager = LinearLayoutManager(this)
        firestore_list.adapter = detailArtikelAdapter
    }

    private fun loadPostData() {
        firebaseRepo.getPostList().addOnCompleteListener{
            if (it.isSuccessful){
                postList = it.result!!.toObjects(PostModel::class.java)
                detailArtikelAdapter.postListitems = postList
                detailArtikelAdapter.notifyDataSetChanged()
            }else{
                Log.d(TAG, "Error: ${it.exception!!.message}")
            }
        }
    }

    override fun invoke(postModel: PostModel) {
        TODO("Not yet implemented")
    }
}