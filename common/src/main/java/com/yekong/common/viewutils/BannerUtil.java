package com.yekong.common.viewutils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import static com.yekong.common.constant.Constant.BANNER_DEBUG;

/**
 * Created by xigua on 2017/10/17.
 */

public class BannerUtil {
    public static List<String> list = new ArrayList<>();
    static {
        list.add("http://img2.imgtn.bdimg.com/it/u=3887082950,4111410538&fm=26&gp=0.jpg");
        list.add("http://img2.imgtn.bdimg.com/it/u=1257582905,2995398711&fm=26&gp=0.jpg");
        list.add("http://img4.imgtn.bdimg.com/it/u=2801782160,3456854724&fm=26&gp=0.jpg");
        list.add("http://img5.imgtn.bdimg.com/it/u=2777907793,655627036&fm=26&gp=0.jpg");
        list.add("http://img2.imgtn.bdimg.com/it/u=3121864619,2165036605&fm=26&gp=0.jpg");
    }

    public static void initBanner(Banner banner, ArrayList<String> images, final BannerClickLinsener linsener) {
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        if (!BANNER_DEBUG)
            banner.setImages(images);
        else
            banner.setImages(list);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        /*//设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);*/
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(4000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        banner.setOnBannerListener(position -> linsener.onItemClick(position));
    }

    public interface BannerClickLinsener{
        void onItemClick(int position);
    }

    private static class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            /**
             注意：
             1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
             2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
             传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
             切记不要胡乱强转！
             */

            //Glide 加载图片简单用法
            Glide.with(context).load(path).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
        }
    }
}
