package com.testkotlin.sdfs.user.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.testkotlin.sdfs.common.activity.BaseActivity
import com.testkotlin.sdfs.user.R
import com.testkotlin.sdfs.user.adapter.SelectCountryAdapter
import kotlinx.android.synthetic.main.activity_select_country.*
import java.util.ArrayList

@Suppress("NAME_SHADOWING")
class SelectCountryActivity : BaseActivity() {

    var mAdapter: SelectCountryAdapter = SelectCountryAdapter()

    override fun getLayoutId(): Int {
        return R.layout.activity_select_country
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        initCountrues()
    }

    private fun initCountrues() {
        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.setLayoutManager(linearLayoutManager)
        mAdapter = SelectCountryAdapter()
        mAdapter.bindToRecyclerView(recyclerView)
        val startLetter: Int = 'A'.toInt()
        val count = 'Z' - 'A'
        val list = ArrayList<String>()
        var bean: String
        val letters = ArrayList<String>()
        for (i in 0..count) {
            bean = (startLetter + i).toChar().toString()
            letters.add(bean)
            list.add(bean + "_Test_1")
            list.add(bean + "_Test_2")
            list.add(bean + "_Test_3")
        }
        mAdapter.setNewData(list)

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val firstVisiblePosition = linearLayoutManager.findFirstVisibleItemPosition()
                if (firstVisiblePosition >= 0 && mAdapter.itemCount - 1 > firstVisiblePosition) {
                    val tvCurrentLetter = findViewById(R.id.tvCurrentLetter) as TextView
                    val bean: String = mAdapter.getItem(firstVisiblePosition) as String
                    tvCurrentLetter.run {
                        setSelectLetter(bean)
                        setText(bean[0].toString())
                    }
                    val tvLetter = mAdapter.getViewByPosition(
                        firstVisiblePosition + 1,
                        R.id.tvLetter
                    ) as TextView
                    if (tvLetter.visibility == View.VISIBLE) {
                        val parent = tvLetter.parent as View
                        val top = parent.top
                        val height = tvLetter.height
                        if (top < height && top >= 0) {
                            tvCurrentLetter.run {
                                scrollTo(0, height - top)
                                setBackgroundColor(Color.TRANSPARENT)
                            }
                        } else {
                            tvCurrentLetter.run {
                                scrollTo(0, 0)
                                setBackgroundColor(
                                    ContextCompat.getColor(
                                        this@SelectCountryActivity,
                                        R.color.color_2a2e39
                                    )
                                )}
                        }
                    } else {
                        tvCurrentLetter.run {
                            scrollTo(0, 0)
                            setBackgroundColor(
                                ContextCompat.getColor(
                                    this@SelectCountryActivity,
                                    R.color.color_2a2e39
                                )
                            )}
                    }
                }
            }
        })
        initLetters(letters)
    }


    private fun initLetters(letters: ArrayList<String>) {
        val count = letters.size
        var tvLetter: TextView
        val lp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        for (i in 0 until count) {
            tvLetter = TextView(this)
            tvLetter.tag = letters[i]
            tvLetter.text = letters[i]
            tvLetter.setPadding(0, 0, 30, 0)
            tvLetter.setTextColor(
                ContextCompat.getColor(
                    this,
                    if (i == 0) R.color.color_dabc86 else R.color.color_979797
                )
            )
            llLetters.addView(tvLetter, lp)
            tvLetter.setOnClickListener { v ->
                val letter = v.tag as String
                val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
                val pos = mAdapter.getIndexByLetter(letter)
                val linearLayoutManager = recyclerView.getLayoutManager() as LinearLayoutManager
                linearLayoutManager.scrollToPositionWithOffset(pos, 0)
            }
        }
    }

    private fun setSelectLetter(currentLetter: String) {
        val llLetters = findViewById(R.id.llLetters) as LinearLayout
        val count = llLetters.getChildCount()
        var tv: TextView
        for (i in 0 until count) {
            tv = llLetters.getChildAt(i) as TextView
            tv.setTextColor(
                ContextCompat.getColor(
                    this,
                    if (tv.tag == currentLetter) R.color.color_dabc86 else R.color.color_979797
                )
            )
        }
    }

    override fun onClick(v: View?) {

    }

}