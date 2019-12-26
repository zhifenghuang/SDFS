package com.testkotlin.sdfs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @BindView(R.id.ll_navigator)
    lateinit var llNavigator: LinearLayout;

    var unbinder: Unbinder? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        unbinder = ButterKnife.bind(this);

        val count = ll_navigator.childCount
        var itemView: View
        for (i in 0 until count) {
            itemView = ll_navigator.getChildAt(i);
            itemView.setTag(i);
            itemView.setOnClickListener(View.OnClickListener {
                resetBottom(it.tag as Int)
            })
        }
        resetBottom(0)
    }

    fun resetBottom(index: Int) {
        val count = ll_navigator.childCount
        var itemView: LinearLayout
        var isEqual:Boolean
        for (i in 0 until count) {
            itemView = ll_navigator.getChildAt(i) as LinearLayout
            isEqual=(i==index)
            (itemView.getChildAt(0) as ImageView).isSelected = isEqual
            (itemView.getChildAt(1) as TextView).
               setTextColor(ContextCompat.getColor(this,if(isEqual){R.color.color_dabc86}else{R.color.color_979797}))
        }
    }

    override fun onDestroy() {
        super.onDestroy();
        unbinder?.unbind()
    }
}
