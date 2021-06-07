package com.example.capstoneprojectpadiku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.example.padi_ku.ui.news.NewsFragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var chipNavigationBar: ChipNavigationBar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)
        chipNavigationBar = findViewById(R.id.bottom_navbar)
        chipNavigationBar?.setItemSelected(R.id.menu_dashboard, true)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragmnet, DashboardFragment()).commit()
        bottomMenu()
    }


    private fun bottomMenu() {
        chipNavigationBar?.setOnItemSelectedListener(object : ChipNavigationBar.OnItemSelectedListener {
            override fun onItemSelected(i: Int) {
                var fragment: Fragment? = null
                when (i) {
                    R.id.menu_dashboard -> fragment = DashboardFragment()
                    R.id.menu_news -> fragment = NewsFragment()

                }
                supportFragmentManager.beginTransaction().replace(
                    R.id.container_fragmnet,
                    fragment!!
                ).commit()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        when (id) {
            R.id.action_change_settings -> DashboardFragment()          // do stuff, like showing settings fragment
        }
        return super.onOptionsItemSelected(item) // important line
    }
}