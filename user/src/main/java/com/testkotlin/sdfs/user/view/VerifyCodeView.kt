package com.testkotlin.sdfs.user.view

import android.content.Context
import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.testkotlin.sdfs.user.R
import kotlinx.android.synthetic.main.verify_code_view.view.*
import java.util.ArrayList

class VerifyCodeView(context: Context?, attrs: AttributeSet?) : RelativeLayout(context, attrs) {

    private val MAX_CODE_SIZE = 6
    private var tvCodes = ArrayList<TextView>(MAX_CODE_SIZE)
    private var lines = ArrayList<View>(MAX_CODE_SIZE)

    private val mCodes = ArrayList<String>()
    private var mOnInputListener: OnInputListener? = null



    init {
        LayoutInflater.from(getContext()).inflate(R.layout.verify_code_view, this)
        initView()
        initEvent()
    }

    private fun initView() {
        var id: Int
        for (i in 0 until MAX_CODE_SIZE) {
            id = resources.getIdentifier("tvCode$i", "id", context.packageName)
            tvCodes.add(findViewById(id) as TextView)
            id = resources.getIdentifier("line$i", "id", context.packageName)
            lines.add(findViewById(id) as View)
        }
    }

    private fun initEvent() {
        //验证码输入
        etCode.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable?) {
                if (editable != null && editable.length > 0) {
                    etCode.setText("")
                    if (mCodes.size < MAX_CODE_SIZE) {
                        mCodes.add(editable.toString())
                        showCode()
                    }
                }
            }
        })
        // 监听验证码删除按键
        etCode.setOnKeyListener(OnKeyListener { view, keyCode, keyEvent ->
            if (keyCode == KeyEvent.KEYCODE_DEL && keyEvent.action == KeyEvent.ACTION_DOWN && mCodes.size > 0) {
                mCodes.removeAt(mCodes.size - 1)
                showCode()
                return@OnKeyListener true
            }
            false
        })
    }

    /**
     * 显示输入的验证码
     */
    private fun showCode() {
        val size = mCodes.size
        val color_default = ContextCompat.getColor(context,R.color.color_404552)
        val color_focus = ContextCompat.getColor(context,R.color.color_dabc86)
        for (i in 0 until MAX_CODE_SIZE) {
            tvCodes[i].text = if (size > i) mCodes[i] else ""
            tvCodes[i].setTextColor(if (i == size - 1) color_focus else Color.WHITE)
            lines[i].setBackgroundColor(if (i == size - 1) color_focus else color_default)
        }
        callBack()//回调
    }


    /**
     * 回调
     */
    private fun callBack() {
        if (mOnInputListener == null) {
            return
        }
        if (mCodes.size == MAX_CODE_SIZE) {
            mOnInputListener!!.onSucess(getPhoneCode())
        } else {
            mOnInputListener!!.onInput()
        }
    }

    fun setOnInputListener(onInputListener: OnInputListener) {
        this.mOnInputListener = onInputListener
    }

    /**
     * 获得手机号验证码
     *
     * @return 验证码
     */
    fun getPhoneCode(): String {
        val sb = StringBuilder()
        for (code in mCodes) {
            sb.append(code)
        }
        return sb.toString()
    }
}