package naser.badr.ana.elraees;

import android.app.Activity;
import android.content.Context;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;


/**
 * Created by ahmed on 10/11/2017.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater inflater;
    LinearLayout linearLayout ;
    private Integer [] images = {R.drawable.q75,R.drawable.q74,R.drawable.q73,R.drawable.q72,R.drawable.q71,R.drawable.q70,R.drawable.q69,R.drawable.q68,R.drawable.q67,R.drawable.q66,R.drawable.q65,R.drawable.q64,R.drawable.q63,R.drawable.q62,R.drawable.q61,R.drawable.q60,R.drawable.q59,R.drawable.q58,R.drawable.q57,R.drawable.q56,R.drawable.q55,R.drawable.q54,R.drawable.q53,R.drawable.q52,R.drawable.q51,R.drawable.q50,R.drawable.q49,R.drawable.q48,R.drawable.q47,R.drawable.q46,R.drawable.q45,R.drawable.q44,R.drawable.q43,R.drawable.q42,R.drawable.q41,R.drawable.q40,R.drawable.q39,R.drawable.q38,R.drawable.q37,R.drawable.q36,R.drawable.q35,R.drawable.q34,R.drawable.q33,R.drawable.q32,R.drawable.q31,R.drawable.q30,R.drawable.q29,R.drawable.q28,R.drawable.q27,R.drawable.q26,R.drawable.q25,R.drawable.q24,R.drawable.q23,R.drawable.q22,R.drawable.q21,R.drawable.q20,R.drawable.q19,R.drawable.q18,R.drawable.q17,R.drawable.q16,R.drawable.q15,R.drawable.q14,R.drawable.q13,R.drawable.q12,R.drawable.q11,R.drawable.q10,R.drawable.q9,R.drawable.q8,R.drawable.q7,R.drawable.q6,R.drawable.q5,R.drawable.q4,R.drawable.q3,R.drawable.q2,R.drawable.q1,R.drawable.q0};
    public  ViewPagerAdapter(Context context)
    {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_image, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        imageView.setImageResource(images[position]);
        ViewPager pager = (ViewPager) container;
        pager.addView(view, 0);

        linearLayout = (LinearLayout) ((Activity)context).findViewById(R.id.linerlayout);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearLayout.getVisibility() == View.VISIBLE) {
                    linearLayout.setVisibility(View.GONE);
                } else {
                    linearLayout.setVisibility(View.VISIBLE);
                }

            }
        });

        return  view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager pager = (ViewPager) container;
        View view = (View) object;
        pager.removeView(view);
    }
}
