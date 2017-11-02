package com.yekong.kotlin_common.dialog

import android.content.Context
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.TextView
import com.cunoraz.gifview.library.GifView
import com.yekong.kotlin_common.R

/**
 * Created by xigua on 2017/10/19.
 */
class CustomAlertDialog : BaseDialog {
    var ctx : Context = null!!
    var alertDialog :AlertDialog
    var hintText : String = "..."
    var isCreate = false
    var gifView : GifView = null!!


    constructor(ctx: Context) : this (ctx,"加载中...")  {}

    constructor(ctx: Context, hintText: String):super() {
        this.ctx = ctx
        this.hintText = hintText
    }



    override fun create() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var view = View.inflate(ctx, R.layout.comm_dialog_network,null)
        alertDialog = AlertDialog.Builder(ctx)
                .setView(view)
                .setCancelable(false)
                .create()
        alertDialog.window.setBackgroundDrawableResource(R.drawable.transparent)
        var text = view.findViewById<TextView>(R.id.tv_text)
        text.text = hintText
        gifView = view.findViewById(R.id.iv_icon)
        gifView.gifResource = R.mipmap.net_loading
        gifView.play()
        isCreate = true
    }

    override fun show() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        if (!isCreate) {
            create()
        }
        if (!alertDialog.isShowing)
            alertDialog.show()
    }

    override fun close() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        if (alertDialog.isShowing) {
            alertDialog.dismiss()
        }
    }
}