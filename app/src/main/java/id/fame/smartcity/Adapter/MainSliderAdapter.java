package id.fame.smartcity.Adapter;

import java.util.List;

import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class MainSliderAdapter extends SliderAdapter {

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder viewHolder) {
        switch (position) {
            case 0:
                viewHolder.bindImageSlide("http://103.163.38.140/simpatik-mobile/assets/check/3302193107980003/2022-03-21_13-41-53.jpg");
                break;
            case 1:
                viewHolder.bindImageSlide("http://103.163.38.140/simpatik-mobile/assets/check/3302193107980003/2022-03-18_22-29-25.jpg");
                break;
            case 2:
                viewHolder.bindImageSlide("http://103.163.38.140/simpatik-mobile/assets/check/3302193107980003/2022-03-17_18-52-50.jpg");
                break;
        }
    }
}
