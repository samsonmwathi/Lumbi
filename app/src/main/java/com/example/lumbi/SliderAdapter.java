package com.example.lumbi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public SliderAdapter(Context context){
        this.context=context;
    }
    //Arrays to store the values for each screen
    public int[] slide_images={
        R.drawable.family,
        R.drawable.mother,
        R.drawable.panda_av
    };
    public String[] slide_headings={
            "Read",
            "count",
            "grow"
    };

    public String[] slide_desc={
            "Lumbi allows learners to learn reading skills through memory exercises that help them learn the basic alphabet and simple words",
            "Lumbi helps learners to learn numbers and counting through flashcards and counting exercises",
            "Lumbi helps learners to learn basic hygiene with the help of their parent from brushing teeth to going to the potty, they'll be clean and happy"
    };

    //return total number of headings to get total number of slides
    @Override
    public int getCount() {
        return slide_headings.length;
    }
    //assign view
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = view.findViewById(R.id.slideImageView);
        TextView slideTitleView = view.findViewById(R.id.titleTextView);
        TextView slideBodyView = view.findViewById(R.id.bodyTextView);

        slideImageView.setImageResource(slide_images[position]);
        slideTitleView.setText(slide_headings[position]);
        slideBodyView.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);

    }
}
























