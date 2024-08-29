package naser.badr.ana.elraees;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.FullScreenContentCallback;

import java.util.ArrayList;

public class Favorit extends Shard {

    private FavoritAdapter2 Fadapter;
    private ListView list;
    private ArrayList<Integer> pages;
    private Database myDB;
    private InterstitialAd mInterstitialAd;
    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_favorit);
        //MobileAds.initialize(this, getString(R.string.YOUR_ADMOB_APP_ID));

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(128);
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.screenBrightness = 255-getIntPreference();
        getWindow().setAttributes(layoutParams);
        RequestConfiguration requestConfiguration = MobileAds.getRequestConfiguration()
                .toBuilder()
                .setTagForChildDirectedTreatment(
                        RequestConfiguration.TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE)
                .setMaxAdContentRating(RequestConfiguration.MAX_AD_CONTENT_RATING_G)
                .build();
        MobileAds.setRequestConfiguration(requestConfiguration);
        final AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener(){

            @Override
            public void onAdLoaded() {
                mAdView.setVisibility(View.VISIBLE);
                Log.i("Ads", "onAdLoaded");
            }
        });
        pages = new ArrayList<>();
        myDB = new Database(this);

        viewAll();
        Fadapter = new FavoritAdapter2(this, pages);

        list = (ListView) findViewById(R.id.favoritlist);

        list.setAdapter(Fadapter);

    }
    @Override
    protected void onPause(){
        super.onPause();
        //  IronSource.onPause(this);
        //  mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
       /* if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }*/
    }
    @Override
    public void onResume() {
        super.onResume();
        //  IronSource.onResume(this);
    }


    public void viewAll()
    {
        Cursor res = myDB.getAllData();
        if (0 ==res.getCount()) {
            return;
        }
        while (res.moveToNext()) {
            pages.add(res.getInt(0));
        }

    }

    public class FavoritAdapter2 extends ArrayAdapter {
        Typeface tp ;
        private Context context;
        private ArrayList<Integer> pages;
        private Database myDB;

        public FavoritAdapter2(@NonNull Context context, ArrayList<Integer> pages) {
            super(context, R.layout.favorit_raw, pages);


            this.context = context;
            this.pages = pages;
            tp = Typeface.createFromAsset(this.context.getAssets(),"fonts/DTNASKH4.TTF");
        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.favorit_raw, parent, false);

            TextView text = (TextView) row.findViewById(R.id.favorititem);
            text.setTypeface(tp);
            ImageButton del = (ImageButton) row.findViewById(R.id.delete);
            myDB = new Database(context);


            text.setText("صفحة رقم " + (pages.get(position)+1) );

            del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myDB.deleteData(pages.get(position).toString());
                    pages.remove(position);
                    notifyDataSetChanged();
                    if (0 == myDB.getAllData().getCount()){
                        if (MainActivity.button3.getVisibility()==View.VISIBLE){
                            MainActivity.button3.setVisibility(View.GONE);
                        }

                        Intent intent = new Intent(context, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                }

            });

            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    //intent.putExtra("index", pages.get(position));
                    savePuzzelCount(pages.get(position));
                    savePuzzelCount2(pages.get(position));
                    context.startActivity(intent);

                }
            });

            return row;
        }
    }
}