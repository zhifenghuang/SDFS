package com.testkotlin.sdfs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

@Route(path = "/app/MainActivity")
class MainActivity : AppCompatActivity() {

    var mFragments: ArrayList<Fragment> = ArrayList(4);
    var mCurrentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        setContentView(R.layout.activity_main)
        val count = ll_navigator.childCount
        var itemView: View
        for (i in 0 until count) {
            itemView = ll_navigator.getChildAt(i);
            itemView.setTag(i);
            itemView.setOnClickListener {
                val tag:Int = it.tag as Int
                switchFragment(mFragments.get(tag))
                resetBottom(tag)
            }
        }
        initFragments()
        switchFragment(mFragments.get(0))
        resetBottom(0)
    }

    fun initFragments(){
        mFragments.add(ARouter.getInstance().build("/user/DiscoverFragment").navigation() as Fragment)
        mFragments.add(ARouter.getInstance().build("/user/UserCenterFragment").navigation() as Fragment)
        mFragments.add(ARouter.getInstance().build("/user/DiscoverFragment").navigation() as Fragment)
        mFragments.add(ARouter.getInstance().build("/user/UserCenterFragment").navigation() as Fragment)
    }

    fun resetBottom(index: Int) {
        val count = ll_navigator.childCount
        var itemView: LinearLayout
        var isEqual: Boolean
        for (i in 0 until count) {
            itemView = ll_navigator.getChildAt(i) as LinearLayout
            isEqual = (i == index)
            (itemView.getChildAt(0) as ImageView).isSelected = isEqual
            (itemView.getChildAt(1) as TextView).setTextColor(
                ContextCompat.getColor(
                    this,
                    if (isEqual) {
                        R.color.color_dabc86
                    } else {
                        R.color.color_979797
                    }
                )
            )
        }
    }

    /**
     * @param to 马上要切换到的Fragment，一会要显示
     */
    fun switchFragment(to: Fragment) {
        if (mCurrentFragment !== to) {
            val ft = supportFragmentManager.beginTransaction()
            if (!to.isAdded()) {
                if (mCurrentFragment != null) {
                    ft.hide(mCurrentFragment!!)
                }
                ft.add(R.id.container, to).commit()
            } else {
                if (mCurrentFragment != null) {
                    ft.hide(mCurrentFragment!!)
                }
                ft.show(to).commit()
            }
        }
        mCurrentFragment = to
    }
}
