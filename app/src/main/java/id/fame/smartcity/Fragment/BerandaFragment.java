package id.fame.smartcity.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import id.fame.smartcity.Adapter.MainSliderAdapter;
import id.fame.smartcity.R;
import id.fame.smartcity.Utils.PicassoImageLoadingService;
import ss.com.bannerslider.Slider;

public class BerandaFragment extends Fragment {
    
    SwipeRefreshLayout swipeRefresh;
    Slider bannerSlider;
    ImageView ivLainnya;
    View BottomSheet;
    BottomSheetBehavior SheetBehavior;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_beranda, container, false);


        swipeRefresh = v.findViewById(R.id.swipeRefresh);
        bannerSlider = v.findViewById(R.id.banner_slider);
        ivLainnya = v.findViewById(R.id.ivLainnya);
        BottomSheet = v.findViewById(R.id.bottomSheet);
        swipeRefresh.setOnRefreshListener(this::initComponent);

        Slider.init(new PicassoImageLoadingService(getContext()));
        bannerSlider.setAdapter(new MainSliderAdapter());
        bannerSlider.setInterval(5000);
        bannerSlider.setLoopSlides(true);
//        bannerSlider.setOnSlideClickListener(position -> {
//                            startActivity(new Intent(context, UploadGambarActivity.class));
//            if (!b.isNullOrEmpty(listBanner.get(position).getLink())) {
//                startActivity(new Intent(context, WebviewActivity.class).putExtra("data", listBanner.get(position).getLink()));
//            }
//        });

        SheetBehavior = BottomSheetBehavior.from(BottomSheet);
        SheetBehavior.setHideable(true);
        SheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        ivLainnya.setOnClickListener(x -> {
            SheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        });

        return v;


    }

    private void initComponent() {
        swipeRefresh.setRefreshing(false);
    }
}