package com.learn.growthcodelab.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learn.growthcodelab.R;
import com.learn.growthcodelab.view.viewpager.InfiniteViewPager;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends BaseActivity {

    public static void start(Context context){
        context.startActivity(new Intent(context, ViewPagerActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        InfiniteViewPager infiniteViewPager = (InfiniteViewPager) findViewById(R.id.view_pager);
        List<Integer> colorIntList = new ArrayList<>();
        colorIntList.add(ContextCompat.getColor(this, android.R.color.holo_red_dark));
        colorIntList.add(ContextCompat.getColor(this, android.R.color.holo_blue_dark));
        colorIntList.add(ContextCompat.getColor(this, android.R.color.holo_green_light));
        colorIntList.add(ContextCompat.getColor(this, android.R.color.holo_orange_dark));
        infiniteViewPager.setAdapter(new SimpleViewPagerAdapter(colorIntList));
    }

    private static class SimpleViewPagerAdapter extends PagerAdapter{

        final List<Integer> mColorIntList;

        public SimpleViewPagerAdapter(List<Integer> colorIntList) {
            mColorIntList = colorIntList;
        }

        @Override
        public int getCount() {
            return mColorIntList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View item = LayoutInflater.from(container.getContext()).inflate(R.layout.view_pager_item_color, container, false);
            item.setBackgroundColor(mColorIntList.get(position));
            container.addView(item);
            return item;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }
}
