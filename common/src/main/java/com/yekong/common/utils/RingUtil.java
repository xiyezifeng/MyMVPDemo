package com.yekong.common.utils;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;

import java.io.IOException;

public class RingUtil {
    public static final String RKEY = "ringing";//铃声
    public static final String SKEY = "shake";//震动


    private static volatile RingUtil singleton;

    private RingUtil() {
    }

    public static RingUtil getInstance() {
        if (singleton == null) {
            synchronized (RingUtil.class) {
                if (singleton == null) {
                    singleton = new RingUtil();
                }
            }
        }
        return singleton;
    }

    /**
     * 响铃
     * @param context
     */
    public void startRing(Context context){
    // 使用来电铃声的铃声路径
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    // 如果为空，才构造，不为空，说明之前有构造过
        MediaPlayer mMediaPlayer = null;
        if(mMediaPlayer == null)
            mMediaPlayer = new MediaPlayer();
        try {
            mMediaPlayer.setDataSource(context, uri);
            mMediaPlayer.setLooping(false); //循环播放
            mMediaPlayer.prepare();
            mMediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 震动
     * @param context
     */
    public void startShake(Context context){
        Vibrator vibrator = null;
        if (vibrator == null) {
            //获取震动服务
            vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        }
        //震动模式隔1秒震动1.4秒
        long[] pattern = { 200, 500 };
        //震动重复，从数组的0开始（-1表示不重复）
        vibrator.vibrate(pattern, -1);
    }
}