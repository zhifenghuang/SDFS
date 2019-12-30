package com.testkotlin.user.view

import android.content.Context
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import com.testkotlin.sdfs.user.R

class InputView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    lateinit var tvTitle: TextView
    lateinit var etValue: EditText
    lateinit var tvValue: TextView
    lateinit var flRight: FrameLayout
    lateinit var ivRight: ImageView
    lateinit var tvRight: TextView

    var mTextType: Int = 0  //0表示EditText,1表示TextView
    var mRightType: Int = 0  //0表示ImageView,1表示TextView
    var mTextColor: Int = 0

    init {
        initView()
        val array = context!!.obtainStyledAttributes(attrs, R.styleable.InputView)
        mTextType = array.getInt(R.styleable.InputView_Text_View_Type, 0)
        if (mTextType == 0) {
            etValue.setVisibility(View.VISIBLE)
            tvValue.setVisibility(View.GONE)
        } else {
            etValue.setVisibility(View.GONE)
            tvValue.setVisibility(View.VISIBLE)
        }
        var text = array.getString(R.styleable.InputView_Text_Hint)
        if (!TextUtils.isEmpty(text)) {
            tvTitle.setText(text)
            tvValue.setText(text)
            etValue.setHint(text)
        }
        var color = array.getColor(R.styleable.InputView_Hint_Color, 0)
        tvTitle.setTextColor(color)
        tvValue.setTextColor(color)
        etValue.setHintTextColor(color)

        mTextColor = array.getColor(R.styleable.InputView_Text_Color, 0)
        etValue.setTextColor(mTextColor)

        mRightType = array.getInt(R.styleable.InputView_Right_View_Type, -1)
        if (mRightType >= 0) {
            flRight.setVisibility(View.VISIBLE)
            if (mRightType == 0) {
                ivRight.setVisibility(View.VISIBLE)
                val drawable = array.getDrawable(R.styleable.InputView_Right_Drawable)
                if (drawable != null) {
                    ivRight.setImageDrawable(drawable)
                }
                tvRight.setVisibility(View.GONE)
            } else {
                ivRight.setVisibility(View.GONE)
                tvRight.setVisibility(View.VISIBLE)
                text = array.getString(R.styleable.InputView_Right_Text)
                if (!TextUtils.isEmpty(text)) {
                    tvRight.setText(text)
                }
                color = array.getColor(R.styleable.InputView_Right_Text_Color, 0)
                tvRight.setTextColor(color)
            }
        }
        array.recycle()
    }


    fun initView() {
        View.inflate(context, R.layout.input_view, this)
        tvTitle = findViewById(R.id.tvTitle)
        etValue = findViewById(R.id.etValue)
        tvValue = findViewById(R.id.tvValue)
        flRight = findViewById(R.id.flRight)
        ivRight = findViewById(R.id.ivRight)
        tvRight = findViewById(R.id.tvRight)
        initEvent()
    }

    fun setTextInputType(type: Int) {
        if (mTextType == 0) {
            etValue.setInputType(type)
        }
    }

    fun setText(text: String) {
        if (mTextType == 0) {
            etValue.setText(text)
        } else {
            if (mTextType == 1) {
                tvValue.setTextColor(mTextColor)
            }
            tvValue.setText(text)
        }
    }

    fun setRightText(text: String) {
        tvRight.setText(text)
    }

    private fun initEvent() {
        etValue.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                val text = charSequence.toString()
                if (TextUtils.isEmpty(text)) {
                    etValue.setGravity(Gravity.CENTER_VERTICAL)
                    tvTitle.setVisibility(View.GONE)
                } else {
                    etValue.setGravity(Gravity.TOP)
                    tvTitle.setVisibility(View.VISIBLE)
                }
            }

            override fun afterTextChanged(editable: Editable) {

            }
        })
    }
}