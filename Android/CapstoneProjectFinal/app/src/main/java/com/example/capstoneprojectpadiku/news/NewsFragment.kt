package com.example.padi_ku.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capstoneprojectpadiku.R
import com.example.capstoneprojectpadiku.news.model.ModelNews
import com.example.capstoneprojectpadiku.news.model.NewsModel
import com.example.padi_ku.ui.news.adapter.NewsAdapter
import com.example.padi_ku.ui.news.networking.ApiEndPoint.getApiClient
import com.example.padi_ku.ui.news.networking.ApiInterface
import com.example.padi_ku.ui.news.utils.Utils.getCountry
import kotlinx.android.synthetic.main.fragment_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsFragment : Fragment() {

    companion object {
        const val API_KEY = "895f8487508d4c4c9d3ec54a4399386d"
    }

    var strCategory = "technology"
    var strCountry: String? = null
    var newsModel: MutableList<NewsModel> = ArrayList()
    var newsAdapter: NewsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        text_news.setText("Berita Utama")
        rvNews.setLayoutManager(LinearLayoutManager(context))
        rvNews.setHasFixedSize(true)
        rvNews.showShimmerAdapter()

        image_refresh.setOnClickListener{
            rvNews.showShimmerAdapter()
            getListNews()
        }
        getListNews()
    }

    private fun getListNews(){

        strCountry = getCountry()

        val apiInterface = getApiClient().create(ApiInterface::class.java)
        val call = apiInterface.getHeadlines(strCountry, strCategory, API_KEY)
        call.enqueue(object : Callback<ModelNews> {
            override fun onResponse(call: Call<ModelNews>, response: Response<ModelNews>){
                if (response.isSuccessful && response.body() != null) {
                    newsModel = response.body()?.newsModel as MutableList<NewsModel>
                    newsAdapter = NewsAdapter(newsModel, context!!)
                    rvNews.adapter = newsAdapter
                    newsAdapter?.notifyDataSetChanged()
                    rvNews.hideShimmerAdapter()
                }
            }
            override fun onFailure(call: Call<ModelNews>, t: Throwable) {
                Toast.makeText(context, "Oops, jaringan kamu bermasalah.", Toast.LENGTH_SHORT).show()
            }
        })

    }

}