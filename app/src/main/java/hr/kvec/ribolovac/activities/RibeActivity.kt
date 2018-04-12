package hr.kvec.ribolovac.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import hr.kvec.ribolovac.R
import hr.kvec.ribolovac.fragments.RibeFragment

class RibeActivity : FragmentActivity() {

    private var viewPager: ViewPager? = null
    val NUM_PAGES = 5
    private var pagerAdapter: PagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_ribe)

        viewPager = findViewById(R.id.ribe_pager)
        pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
        viewPager!!.adapter = pagerAdapter
    }

    override fun onBackPressed() {

        if (viewPager!!.currentItem == 0) super.onBackPressed()
        else viewPager!!.currentItem = viewPager!!.currentItem.minus(1)

    }

    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {

            return RibeFragment()

        }

        override fun getCount(): Int {
            return NUM_PAGES
        }
    }

}

