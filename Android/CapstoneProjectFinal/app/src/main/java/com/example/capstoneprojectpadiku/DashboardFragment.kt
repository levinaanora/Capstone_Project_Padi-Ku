package com.example.capstoneprojectpadiku

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.capstoneprojectpadiku.Information.InformationActivity
import com.example.capstoneprojectpadiku.artikel.ArticleActivity
import kotlinx.android.synthetic.main.about_us.view.*
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : Fragment() {

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if(item.itemId == R.id.action_change_settings){
//            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
//            startActivity(mIntent)
//        }
//        return super.onOptionsItemSelected(item)
//    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonCamera = view.findViewById<ImageButton>(R.id.btnCamera)
        val buttonArticle = view.findViewById<ImageButton>(R.id.btnArticle)
        val buttonInfo = view.findViewById<ImageButton>(R.id.btnInfo)
        val buttonAboutUs = view.findViewById<ImageButton>(R.id.btnAboutUs)
        val imageSlider = view.findViewById<ImageSlider>(R.id.slider)
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel("https://cdn.discordapp.com/attachments/837607276377931806/849636029362733056/Proyek_Baru_1.png"))
        imageList.add(SlideModel("https://cdn.discordapp.com/attachments/837607276377931806/849648579533471814/Proyek_Baru_4.png"))
        imageList.add(SlideModel("https://cdn.discordapp.com/attachments/837607276377931806/849636036078207027/Proyek_Baru.png"))
        imageList.add(SlideModel("https://storage.trubus.id/storage/posts/t20180501/big_890-512-01-05-2018-ketua-hkti-ungkap-5-kendala-yang-dialami-petani-indonesia-saat-ini-1525163385.jpg"))
        imageList.add(SlideModel("https://cdn.discordapp.com/attachments/837607276377931806/849636035134357504/Proyek_Baru_2.png"))

        imageSlider.setImageList(imageList, scaleType = ScaleTypes.FIT)


        setting.setOnClickListener {
            val intent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(intent)
        }
        buttonCamera.setOnClickListener {
            val intent = Intent(getActivity(), CameraActivity::class.java)
            startActivity(intent)
        }

        buttonArticle.setOnClickListener {
            val intent = Intent(getActivity(), ArticleActivity::class.java)
            startActivity(intent)
        }

        buttonInfo.setOnClickListener {
            val intent = Intent(getActivity(), InformationActivity::class.java)
            startActivity(intent)
        }

        buttonAboutUs.setOnClickListener {
            val views = View.inflate(activity, R.layout.about_us, null)

            val builder = AlertDialog.Builder(activity)
            builder.setView(views)

            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            views.btnClose.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}