package com.mashup.lemonsatang.ui.remindWrite

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.mashup.lemonsatang.R
import com.mashup.lemonsatang.ui.remindlist.RemindDate
import com.mashup.lemonsatang.ui.remindlist.RemindListActivity
import kotlinx.android.synthetic.main.activity_remind_write_content.*
import kotlinx.android.synthetic.main.toolbar_remind_list.*


class RemindWriteContentActivity : AppCompatActivity(), RemindDate{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remind_write_content)
        init()
        toolbarClick()
    }

    private fun init(){
        etRemindWriteContent.setText(RemindListActivity.content)
    }
    private fun toolbarClick(){
        tvCompleteToolbarRemind.visibility = View.VISIBLE
        tvCompleteToolbarRemind.setOnClickListener {
            MaterialDialog(this).show{
                message (text =
                getString(R.string.toolbar_remind_dialog_msg, getMonth(RemindListActivity.startDate),getWeekOfMonth(RemindListActivity.startDate)))
                positiveButton (text="확인")
            }
        }

        btnBackToolbarRemind.setOnClickListener {
            onBackPressed()
        }
    }

    private fun showKeyboard(){
        val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

}