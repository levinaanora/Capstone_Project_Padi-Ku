package com.example.capstoneprojectpadiku.artikel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capstoneprojectpadiku.R
import kotlinx.android.synthetic.main.activity_article.*

private const val TAG: String = "HOMEPAGE_LOG"

class ArticleActivity : AppCompatActivity(), (PostModel) -> Unit {

    private val firebaseRepo: FirebaseRepo = FirebaseRepo()
    private var postList: List<PostModel> = ArrayList()
    private val postListAdapter: PostListAdapter = PostListAdapter(postList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

//        val buttonImage: ImageView = findViewById(R.id.image_post_image)
//        buttonImage.setOnClickListener(this)

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
        firestore_list.adapter = postListAdapter
    }

//    override fun onClick(v: View?) {
//        when (v?.id) {
//            R.id.image_post_image -> {
//                val moveIntent = Intent(this@ArticleActivity, DetailArtikelActivity::class.java)
//                startActivity(moveIntent)
//            }
//        }
//    }

    private fun loadPostData() {
        firebaseRepo.getPostList().addOnCompleteListener{
            if (it.isSuccessful){
                postList = it.result!!.toObjects(PostModel::class.java)
                postListAdapter.postListitems = postList
                postListAdapter.notifyDataSetChanged()
            }else{
                Log.d(TAG, "Error: ${it.exception!!.message}")
            }
        }
    }

    // masuk detail
    override fun invoke(postModel: PostModel) {

        Toast.makeText(this,"Clicked on item: ${postModel.Judul}", Toast.LENGTH_LONG).show()
    }
}