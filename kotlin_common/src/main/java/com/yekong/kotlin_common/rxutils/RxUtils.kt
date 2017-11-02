package com.yekong.kotlin_common.rxutils

import android.content.Context
import android.util.Log
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.yekong.kotlin_common.dialog.BaseDialog
import com.yekong.kotlin_common.dialog.CustomAlertDialog
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by xigua on 2017/10/19.
 */
class RxUtils {
    companion object{
        fun <T> createObserver(observable: Observable<T>,context: Context,showDialog : Boolean ,message:String): Observable<T> {
            var dialog : BaseDialog = null!!
            if (showDialog) {
                dialog = createDialog(context,message)!!
            }
            observable
                    .compose { (context as RxAppCompatActivity).lifecycle() }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    /*.onErrorResumeNext {Observable.just("error" as T)
                            .compose((context as RxAppCompatActivity).bindToLifecycle<T>())
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                    }*/
                    .doOnSubscribe {
                        if (showDialog)dialog.show()
                    }
                    .doOnError {
                        Log.e("error","")
                    }
                    .doOnComplete {
                        if (showDialog)dialog.close()
                    }

            return observable

        }
        fun createDialog(context: Context, message: String): BaseDialog? {
            if (message != null) {
                return CustomAlertDialog(context,message)
            }else{
                return CustomAlertDialog(context)
            }
        }

    }
}