package naser.badr.ana.elraees;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
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

public class About extends Shard implements View.OnClickListener{
    private InterstitialAd mInterstitialAd;
    private Button button, button01 ,button02 ,button03 ,button04, button20, button21, button22, button10, button11;
    private int status = 0;
    private ViewFlipper flipper;
    LinearLayout about, book, dev;
    private static final String TAG = "About";

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        RequestConfiguration requestConfiguration = MobileAds.getRequestConfiguration()
                .toBuilder()
                .setTagForChildDirectedTreatment(
                        RequestConfiguration.TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE)
                .setMaxAdContentRating(RequestConfiguration.MAX_AD_CONTENT_RATING_G)
                .build();
        MobileAds.setRequestConfiguration(requestConfiguration);
        AdRequest adRequest = new AdRequest.Builder().build();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(128);
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.screenBrightness = 255 - getIntPreference();
        getWindow().setAttributes(layoutParams);
        mInterstitialAd.load(this,getString(R.string.admob_mInterstitialAd), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d(TAG, loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });
        /*mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
            @Override
            public void onAdClicked() {
                // Called when a click is recorded for an ad.
                Log.d(TAG, "Ad was clicked.");
            }

            @Override
            public void onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                // Set the ad reference to null so you don't show the ad a second time.
                Log.d(TAG, "Ad dismissed fullscreen content.");
                mInterstitialAd = null;
            }

            @Override
            public void onAdFailedToShowFullScreenContent(AdError adError) {
                // Called when ad fails to show.
                Log.e(TAG, "Ad failed to show fullscreen content.");
                mInterstitialAd = null;
            }

            @Override
            public void onAdImpression() {
                // Called when an impression is recorded for an ad.
                Log.d(TAG, "Ad recorded an impression.");
            }

            @Override
            public void onAdShowedFullScreenContent() {
                // Called when ad is shown.
                Log.d(TAG, "Ad showed fullscreen content.");
            }
        });*/
        final AdView mAdView = (AdView) findViewById(R.id.adView);

        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                mAdView.setVisibility(View.VISIBLE);
                Log.i("Ads", "onAdLoaded");
            }
        });



        about = (LinearLayout) findViewById(R.id.about0);
        book = (LinearLayout) findViewById(R.id.book0);
        dev = (LinearLayout) findViewById(R.id.dev0);
/*
        book.setVisibility(View.GONE);
        dev.setVisibility(View.GONE);
*/

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        button01 = (Button) findViewById(R.id.button01);
        button01.setOnClickListener(this);



        button02 = (Button) findViewById(R.id.button02);
        button02.setOnClickListener(this);
        button03 = (Button) findViewById(R.id.button03);
        button03.setOnClickListener(this);
        button04 = (Button) findViewById(R.id.button04);
        button04.setOnClickListener(this);

        button20 = (Button) findViewById(R.id.button20);
        button20.setOnClickListener(this);
        button21 = (Button) findViewById(R.id.button21);
        button21.setOnClickListener(this);
        button22 = (Button) findViewById(R.id.button22);
        button22.setOnClickListener(this);



        button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(this);
        button11 = (Button) findViewById(R.id.button11);
        button11.setOnClickListener(this);

        flipper = (ViewFlipper) findViewById(R.id.content);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            flipper.setDisplayedChild(0);
            status = 0;

        } else {

            flipper.setDisplayedChild(1);
            status = 1;
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            flipper.setDisplayedChild(0);
            status = 0;

        } else {

            flipper.setDisplayedChild(1);
            status = 1;

        }
    }

    void displayInterstitialAd() {
       /* mInterstitialAd.loadAd(new AdRequest.Builder().build());
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }*/
        if (mInterstitialAd != null) {
            mInterstitialAd.show(this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        //  IronSource.onPause(this);
        // mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        /*if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }*/
    }

    @Override
    public void onResume() {
        super.onResume();
        //  IronSource.onResume(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
       /* if(book.getVisibility()==View.VISIBLE){

            book.setVisibility(View.GONE);
            about.setVisibility(View.VISIBLE);


        }else if(dev.getVisibility()==View.VISIBLE){
            dev.setVisibility(View.GONE);
            about.setVisibility(View.VISIBLE);
        }*/
        if(book.getVisibility()==View.VISIBLE||dev.getVisibility()==View.VISIBLE){
            Intent intent2 = new Intent(About.this, About.class);
            intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent2);
            displayInterstitialAd();
        }else {
            Intent intent2 = new Intent(About.this, MainActivity.class);
            intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent2);
            displayInterstitialAd();
        }

    }

    @Override
    public void onClick(View v) {
        if (v == button) {


         /*   button.setVisibility(View.GONE);
            button01.setVisibility(View.GONE);

            button10.setVisibility(View.VISIBLE);
            button11.setVisibility(View.VISIBLE);
            button12.setVisibility(View.VISIBLE);
*/

            about.setVisibility(View.GONE);
            book.setVisibility(View.VISIBLE);





            //startActivity(intent);
        } else if (v == button01) {


            /*
          button.setVisibility(View.GONE);
          button01.setVisibility(View.GONE);

          button20.setVisibility(View.VISIBLE);
          button21.setVisibility(View.VISIBLE);
          button22.setVisibility(View.VISIBLE);
          button23.setVisibility(View.VISIBLE);*/

            about.setVisibility(View.GONE);
            dev.setVisibility(View.VISIBLE);




            // startActivity(intent1);
        } else if (v == button02) {

            //   StartAppAd.showAd(this);

            //       Intent masrysouq = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.masrysouq.com/shop"));

            //        startActivity(masrysouq);


            Intent intent3 = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.facebook.com/groups/134994369869516/"));

            startActivity(intent3);



            // startActivity(intent);
        } else if (v == button03) {

            //      StartAppAd.showAd(this);

            //      Intent masrysouq = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.masrysouq.com/shop"));

            //       startActivity(masrysouq);


            Intent intent3 = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.facebook.com/groups/1735648613363240/"));

            startActivity(intent3);



            // startActivity(intent);
        } else if (v == button04) {

            //      StartAppAd.showAd(this);

            //   Intent masrysouq = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.masrysouq.com/shop"));

            //  startActivity(masrysouq);


            Intent intent3 = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.facebook.com/%D9%83%D8%AA%D8%A7%D8%A8-%D8%A7%D9%84%D8%B9%D8%A7%D9%84%D9%85-%D8%A3%D8%AD%D8%B2%D8%A7%D8%A8-%D9%88-%D8%A3%D9%88%D8%B1%D8%A7%D8%AF-%D9%88-%D9%81%D8%B6%D8%A7%D8%A6%D9%84-532576100187819"));

            startActivity(intent3);



            // startActivity(intent);
        } else if (v == button20) {

            //      StartAppAd.showAd(this);

            Intent intent20 = new Intent(Intent.ACTION_DIAL);
            intent20.setData(Uri.parse("tel:+201280021862"));

            if (intent20.resolveActivity(getPackageManager()) != null) {
                intent20.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent20);


            }



        } else if (v == button21) {
            //      StartAppAd.showAd(this);

            //   Intent masrysouq = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.masrysouq.com/shop"));

            //   startActivity(masrysouq);


            Intent intent3 = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://menhajelnbowwa.blogspot.com"));

            startActivity(intent3);


            // startActivity(intent);
        } else if (v == button22) {

            //     StartAppAd.showAd(this);

            //   Intent masrysouq = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.masrysouq.com/shop"));

            //     startActivity(masrysouq);


            Intent intent3 = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.facebook.com/profile.php?id=100001661734525"));

            startActivity(intent3);



            // startActivity(intent);
        } else if (v == button10) {

            //       StartAppAd.showAd(this);

            Intent intent20 = new Intent(Intent.ACTION_DIAL);
            intent20.setData(Uri.parse("tel:+201003701365"));

            if (intent20.resolveActivity(getPackageManager()) != null) {
                intent20.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent20);


            }



        } else if (v == button11) {

            //     StartAppAd.showAd(this);

            //      Intent masrysouq = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.masrysouq.com/shop"));

            //      startActivity(masrysouq);


            Intent intent3 = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.facebook.com/profile.php?id=100001605614245"));

            startActivity(intent3);



            // startActivity(intent);
        }

        //  StartAppAd.showAd(this);
    }
}


