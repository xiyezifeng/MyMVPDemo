package com.yekong.kotlin_common.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import butterknife.ButterKnife
import java.lang.reflect.ParameterizedType

/**
 * Created by xigua on 2017/10/19.
 */
abstract class BaseActivity<P : BasePresenter<*,*> ,M : BaseModel>  : AppCompatActivity()
{
    val TAG : String = "ACTIVITY"

    var p : P ?= null
    var m : M ?= null
    val TYPE_NOMAL = 1
    val TYPE_REFRUSH = 0
    val TYPE_MORE  = 1
    var TYPE : Int = TYPE_NOMAL
    var context : Context = null!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        p = getT(this, 0)
        m = getT(this, 1)
        context = this
        m!!.context = context
        p!!.context = context
        setPresenter()
        if (getContentRes() > 0) {
            setContentView(getContentRes())
            ButterKnife.bind(this)
            initView()
            initData()
        }
    }

    fun <T> getT ( o : Any , i : Int): T {
        return (((o.javaClass.genericSuperclass) as ParameterizedType ).actualTypeArguments[i] as Class<T>).newInstance()
    }

    fun test():String{
        return "12"
    }

    fun log(l : String){
        Log.e(TAG,l)
    }
    fun <T> getView(id : Int):T{
        return findViewById(id) as T
    }
    fun openActivity(cls : Class<*>){
        startActivity(Intent(context, cls))
    }

    abstract fun setPresenter()
    abstract fun getContentRes() : Int

    abstract fun initView()
    abstract fun initData()

}