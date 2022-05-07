package thuyhai.tchl.project_final.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.List;

import thuyhai.tchl.project_final.R;
import thuyhai.tchl.project_final.models.Photo_Model;

public class Slide_Photo_Adapter extends PagerAdapter {
    private Context mContext;
    private List<Photo_Model> mListPhoto;

    public Slide_Photo_Adapter(Context mContext, List<Photo_Model> mListPhoto) {
        this.mContext = mContext;
        this.mListPhoto = mListPhoto;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.itemphoto,container,false);
        ImageView imgPhoto = view.findViewById(R.id.img_photo);

        Photo_Model photo = mListPhoto.get(position);
        if (photo != null){
            Glide.with(mContext).load(photo.getResourceID()).into(imgPhoto);
        }
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        if(mListPhoto != null){
            return mListPhoto.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
