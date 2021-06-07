package com.example.capstoneprojectpadiku.Information

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capstoneprojectpadiku.R
import kotlinx.android.synthetic.main.activity_information.*

private const val TAG: String = "HOMEPAGE_LOG"

class InformationActivity : AppCompatActivity() , (InfoModel) -> Unit{

    private val infoRepo: InfoRepo = InfoRepo()
    private var infoList: List<InfoModel> = ArrayList()
    private val infoListAdapter: InfoListAdapters = InfoListAdapters(infoList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        if(infoRepo.getUser() == null) {
            infoRepo.creteUser().addOnCompleteListener() {
                if (it.isSuccessful) {
                    loadPostData()
                } else {
                    Log.d(TAG, "Error: ${it.exception!!.message}")
                }
            }
        }else{
            loadPostData()
        }

        info_list.layoutManager = LinearLayoutManager(this)
        info_list.adapter = infoListAdapter
    }

    private fun loadPostData() {
        infoRepo.getPostList().addOnCompleteListener{
            if (it.isSuccessful){
                infoList = it.result!!.toObjects(InfoModel::class.java)
                infoListAdapter.infoListitems = infoList
                infoListAdapter.notifyDataSetChanged()
            }else{
                Log.d(TAG, "Error: ${it.exception!!.message}")
            }
        }
    }

    override fun invoke(p1: InfoModel) {
        TODO("Not yet implemented")
    }
}