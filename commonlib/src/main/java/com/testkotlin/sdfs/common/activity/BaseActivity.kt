package com.testkotlin.sdfs.common.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

abstract class BaseActivity : AppCompatActivity(), View.OnClickListener {

    protected abstract fun getLayoutId(): Int

    protected abstract fun onCreated(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        onCreated(savedInstanceState)
    }

    protected fun setViewsOnClickListener(vararg views: View) {
        for (view in views) {
            view.setOnClickListener(this)
        }
    }


    protected fun setEditTextHint(et: EditText, text: String?) {
        et.hint = text ?: ""
    }


    protected fun setText(tv: TextView, text: String?) {
        tv.text = text ?: ""
    }

    protected fun setText(tv:TextView, textId: Int) {
        tv.setText(getString(textId))
    }

    protected fun setTextColor(tv: TextView, clorId: Int) {
        tv.setTextColor(ContextCompat.getColor(this, clorId))
    }

    protected fun setImage(iv:ImageView, drawableId: Int) {
        iv.setImageResource(drawableId)
    }

    protected fun setBackground(view:View, drawableId: Int) {
        view.setBackgroundResource(drawableId)
    }

    protected fun getTextById(tv: TextView): String {
        return tv.text.toString().trim { it <= ' ' }
    }

    protected fun setViewVisible(vararg views: View) {
        for (view in views) {
            view.setVisibility(View.VISIBLE)
        }
    }

    protected fun setViewGone(vararg views: View) {
        for (view in views) {
            view.setVisibility(View.GONE)
        }
    }

    protected fun setViewInvisible(vararg views: View) {
        for (view in views) {
            view.setVisibility(View.INVISIBLE)
        }
    }

    protected fun goPager(cls: Class<*>) {
        goPager(cls, null)
    }

    protected fun goPager(cls:Class<*>,bundle: Bundle?){
        val intent=Intent(this,cls)
        if(bundle!=null){
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }
}