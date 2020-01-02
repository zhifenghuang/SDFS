package com.testkotlin.sdfs.user.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.testkotlin.sdfs.user.R

class SelectCountryAdapter :
    BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_select_country) {
    override fun convert(helper: BaseViewHolder?, item: String?) {
        val pos = helper!!.adapterPosition
        if (pos == 0 || getItem(pos - 1)?.get(0) != item?.get(0)) {
            helper.setGone(R.id.tvLetter, true)
            helper.setText(R.id.tvLetter, item?.get(0).toString())
        } else {
            helper.setGone(R.id.tvLetter, false)
        }
        if (pos < itemCount - 1) {
            helper.setGone(R.id.paddingView, !item.equals(getItem(pos + 1)))
        } else {
            helper.setGone(R.id.paddingView, false)
        }
        helper.setText(R.id.tvName, item)
            .setText(R.id.tvCode, "+100")
    }

    fun getIndexByLetter(letter: String): Int {
        val list = data
        var index = 0
        for (bean in list) {
            if (bean[0].toString().equals(letter)) {
                break
            }
            ++index
        }
        return index;
    }

}