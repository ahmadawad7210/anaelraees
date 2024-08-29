package naser.badr.ana.elraees;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.PowerManager;
//import android.support.annotation.NonNull;
//import android.support.design.widget.BottomNavigationView;
//import android.support.design.widget.FloatingActionButton;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.google.ads.consent.ConsentForm;
import com.google.ads.consent.ConsentFormListener;
import com.google.ads.consent.ConsentInfoUpdateListener;
import com.google.ads.consent.ConsentInformation;
import com.google.ads.consent.ConsentStatus;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


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


import java.net.MalformedURLException;
import java.net.URL;



public class MainActivity extends Shard implements View.OnClickListener {

/*
    Context context = getApplicationContext();
    AppSetIdClient client = AppSet.getClient(context);
    Task<AppSetIdInfo> task = client.getAppSetIdInfo();

task.addOnSuccessListener(new OnSuccessListener<AppSetIdInfo>() {
        @Override
        public void onSuccess(AppSetIdInfo info) {
            // Determine current scope of app set ID.
            int scope = info.getScope();

            // Read app set ID value, which uses version 4 of the
            // universally unique identifier (UUID) format.
            String id = info.getId();
        }
    });


 */

    LinearLayout linearLayout;
    int s;
    int y;
    int z;
    private int pg = 0, startPage, current = 0, state = 0, savedPage = 0;
    private Database myDB;
    public int save = 0;

    private ViewFlipper flipper;
    private ViewPager slider;
    private Bundle bundle;
    private ViewPagerAdapter pagerAdapter;
    private Integer[] images = {R.drawable.q0, R.drawable.q1, R.drawable.q2, R.drawable.q3, R.drawable.q4, R.drawable.q5, R.drawable.q6, R.drawable.q7, R.drawable.q8, R.drawable.q9, R.drawable.q10, R.drawable.q11, R.drawable.q12, R.drawable.q13, R.drawable.q14, R.drawable.q15, R.drawable.q16, R.drawable.q17, R.drawable.q18, R.drawable.q19, R.drawable.q20, R.drawable.q21, R.drawable.q22, R.drawable.q23, R.drawable.q24, R.drawable.q25, R.drawable.q26, R.drawable.q27, R.drawable.q28, R.drawable.q29, R.drawable.q30, R.drawable.q31, R.drawable.q32, R.drawable.q33, R.drawable.q34, R.drawable.q35, R.drawable.q36, R.drawable.q37, R.drawable.q38, R.drawable.q39, R.drawable.q40, R.drawable.q41, R.drawable.q42, R.drawable.q43, R.drawable.q44, R.drawable.q45, R.drawable.q46, R.drawable.q47, R.drawable.q48, R.drawable.q49, R.drawable.q50, R.drawable.q51, R.drawable.q52, R.drawable.q53, R.drawable.q54, R.drawable.q55, R.drawable.q56, R.drawable.q57, R.drawable.q58, R.drawable.q59, R.drawable.q60, R.drawable.q61, R.drawable.q62, R.drawable.q63, R.drawable.q64, R.drawable.q65, R.drawable.q66, R.drawable.q67, R.drawable.q68, R.drawable.q69, R.drawable.q70, R.drawable.q71, R.drawable.q72, R.drawable.q73, R.drawable.q74, R.drawable.q75};
    private ListView list;
    private ImageAdapter imageAdapter;
    private int status = 0;
    private Button button;
    private InterstitialAd mInterstitialAd;
    private static final String TAG = "MainActivity ----- : ";
    ConsentForm form;
    private int sp;
    private int p = 75;



    protected PowerManager.WakeLock wakeLock;
    Button button1;
    Button button2;
    static Button button3;
    Button button4;
    Button buttonprivecy;
    Button button5;
    Button button6;
    Button button7;

    RelativeLayout linearLayout1;
    TextView exit;

    FloatingActionButton Switcher;
    boolean Dark = false;

    RelativeLayout relativeLayout;
    Context context;
    private static String packageName = "";

    Activity currentActivity;

    private ConsentInformation consentInformation;

    private BottomNavigationView navigation;

    @SuppressLint("InvalidWakeLockTag")
    SeekBar brightness_seekBar;
    float BackLightValue = 0.5f; //dummy default value

    @SuppressLint({"InvalidWakeLockTag", "MissingPermission"})


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(128);

        setContentView(R.layout.activity_main);




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


        final PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        this.wakeLock = powerManager.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, TAG);
        this.wakeLock.acquire();


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mInterstitialAd.load(this, getString(R.string.admob_mInterstitialAd), adRequest,
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
                mInterstitialAd=null;
                Log.d(TAG, "Ad dismissed fullscreen content.");
               // mInterstitialAd = null;

            }

            @Override
            public void onAdFailedToShowFullScreenContent(AdError adError) {
                // Called when ad fails to show.
                mInterstitialAd=null;
                Log.e(TAG, "Ad failed to show fullscreen content.");
              //  mInterstitialAd = null;
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
        });
*/


        final AdView mAdView = (AdView) findViewById(R.id.adView);

        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                mAdView.setVisibility(View.VISIBLE);
                Log.i("Ads", "onAdLoaded");
            }
        });
        ConsentInformation consentInformation =
                ConsentInformation.getInstance(MainActivity.this);
//// test
        // ConsentInformation.getInstance(this).addTestDevice("62577C087ADC5497524E2FAF2B0E67AE");
/////
        String[] publisherIds = {getString(R.string.admob_pub)};
        consentInformation.requestConsentInfoUpdate(publisherIds, new ConsentInfoUpdateListener() {
            @Override
            public void onConsentInfoUpdated(ConsentStatus consentStatus) {
                // User's consent status successfully updated.
                Log.d(TAG, "onConsentInfoUpdated");
                switch (consentStatus) {
                    case PERSONALIZED:
                        Log.d(TAG, "PERSONALIZED");
                        ConsentInformation.getInstance(MainActivity.this)
                                .setConsentStatus(ConsentStatus.PERSONALIZED);
                        break;
                    case NON_PERSONALIZED:
                        Log.d(TAG, "NON_PERSONALIZED");
                        ConsentInformation.getInstance(MainActivity.this)
                                .setConsentStatus(ConsentStatus.NON_PERSONALIZED);
                        break;
                    // User's consent status successfully updated.
                    case UNKNOWN:
                        Log.d(TAG, "UNKNOWN");
                        if
                        (ConsentInformation.getInstance(MainActivity.this).isRequestLocationInEeaOrUnknown
                                ()) {
                            URL privacyUrl = null;
                            try {
// TODO: Replace with your app's privacy policy URL.
                                privacyUrl = new URL("https://sites.google.com/view/ahmad-awad/home");
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
// Handle error.
                            }
                            form = new ConsentForm.Builder(MainActivity.this,
                                    privacyUrl)
                                    .withListener(new ConsentFormListener() {
                                        @Override
                                        public void onConsentFormLoaded() {
// Consent form loaded successfully.
                                            Log.d(TAG, "onConsentFormLoaded");
                                            showform();
                                        }

                                        @Override
                                        public void onConsentFormOpened() {
// Consent form was displayed.
                                            Log.d(TAG, "onConsentFormOpened");
                                        }

                                        @Override
                                        public void onConsentFormClosed(
                                                ConsentStatus consentStatus, Boolean
                                                userPrefersAdFree) {
// Consent form was closed.
                                            Log.d(TAG, "onConsentFormClosed");
                                        }

                                        @Override
                                        public void onConsentFormError(String
                                                                               errorDescription) {
// Consent form error.
                                            Log.d(TAG, "onConsentFormError");
                                            Log.d(TAG, errorDescription);
                                        }
                                    })
                                    .withPersonalizedAdsOption()
                                    .withNonPersonalizedAdsOption()
                                    .build();
                            form.load();
                        } else {
                            Log.d(TAG, "PERSONALIZED else");
                            ConsentInformation.getInstance(MainActivity.this)
                                    .setConsentStatus(ConsentStatus.PERSONALIZED);
                        }
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onFailedToUpdateConsentInfo(String errorDescription) {
                // User's consent status failed to update.
                Log.d(TAG, "onFailedToUpdateConsentInfo");
                Log.d(TAG, errorDescription);
            }
        });
        Log.v("501", "start");
/* bundle = getIntent().getExtras();
        SharedPreferences share = getSharedPreferences("savefil" , Context.MODE_PRIVATE);

        sp = share.getInt("currentPag", 0) ;
*/

        y = getSavedPuzzelCount();
        // z = getSavedPuzzelCount2();
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        exit = (TextView) findViewById(R.id.exit);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        exit.setOnClickListener(this);

        buttonprivecy = (Button) findViewById(R.id.buttonprivecy);
        buttonprivecy.setOnClickListener(this);

        Switcher = findViewById(R.id.switcher);
        Dark = getThemeStatePref();
        if (Dark) {
            // dark theme is on

          /*  searchInput.setBackgroundResource(R.drawable.search_input_dark_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.black));
*/
        } else {
        /*    // light theme is on
            searchInput.setBackgroundResource(R.drawable.search_input_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.white));
*/
        }

        relativeLayout = (RelativeLayout) findViewById(R.id.brightness);
        linearLayout1 = (RelativeLayout) findViewById(R.id.menu_linearLayout_brightness);
        linearLayout1.setOnClickListener(this);


        linearLayout = (LinearLayout) findViewById(R.id.linerlayout);
        linearLayout.setVisibility(View.GONE);

        brightness_seekBar = (SeekBar) findViewById(R.id.brightness_seekBar);
        brightness_seekBar.setProgress(255 - getIntPreference());
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.screenBrightness = brightness_seekBar.getProgress();
        getWindow().setAttributes(layoutParams);
        brightness_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setBrightness(255 - progress);
                WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
                layoutParams.screenBrightness = progress;
                getWindow().setAttributes(layoutParams);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        flipper = (ViewFlipper) findViewById(R.id.content);
        slider = (ViewPager) findViewById(R.id.slider);
        list = (ListView) findViewById(R.id.imageList);

        myDB = new Database(this);

        if(0 == myDB.getAllData().getCount()){
            if(button3.getVisibility()==View.VISIBLE){
                button3.setVisibility(View.GONE);
            }
        }


        pag();
        list();


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            flipper.setDisplayedChild(0);
            list();
            status = 0;

        } else {
            flipper.setDisplayedChild(1);
            pag();
            status = 1;
        }


    }

    private void list() {
        imageAdapter = new ImageAdapter(this, images);
        list = (ListView) findViewById(R.id.imageList);
        list.setAdapter(imageAdapter);
        //startPage = getCurrentPage() ;
            /*if(bundle != null){
                startPage = bundle.getInt("index");
                list.setSelection(startPage);
            }else if (startPage == 0){
                list.setSelection(sp);
            }else {
                list.setSelection(startPage);
            }
*/


        //z = getSavedPuzzelCount();
        z = getSavedPuzzelCount2();
        if (z == 0) {
            s = y;
        } else {
            s = z;
        }

        list.setSelection(s);

        list.setOnScrollListener(new ListView.OnScrollListener() {
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                //setCurrentPage(firstVisibleItem );
                //savePuzzelCount(firstVisibleItem);
                savePuzzelCount2(firstVisibleItem);
                //slider.setCurrentItem(p - firstVisibleItem);
               /* if (tempFirstVisibleItem != firstVisibleItem){
                    savePuzzelCount(firstVisibleItem + 1);
                    tempFirstVisibleItem = firstVisibleItem ;

                }*/

            }

            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }


        });


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                save = position;
                if (linearLayout.getVisibility() == View.VISIBLE) {
                    linearLayout.setVisibility(View.GONE);
                } else {
                    linearLayout.setVisibility(View.VISIBLE);
                }

            }

        });

    }

    private void pag() {
        pagerAdapter = new ViewPagerAdapter(this);
        slider = (ViewPager) findViewById(R.id.slider);
        slider.setAdapter(pagerAdapter);
        /*startPage = getCurrentPage() ;
            if(bundle != null){
                startPage = bundle.getInt("index");
                slider.setCurrentItem(p - startPage);
            }else if (startPage == 0){
                slider.setCurrentItem(p - sp);
            }else {
                slider.setCurrentItem(p - startPage);

            }*/
        // y = getSavedPuzzelCount();
        z = getSavedPuzzelCount2();
        if (z == 0) {
            s = y;
        } else {
            s = z;
        }

        slider.setCurrentItem(p - s);

        slider.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageSelected(int position) {
                //setCurrentPage(p - position);
                savePuzzelCount2(p - position);
                //savePuzzelCount(p-position);
                //list.setSelection(p - position);


            }

            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

        });


    }


    private void showform() {
        if (form != null) {
            Log.d(TAG, "show ok");
            form.show();
        }
    }

    @Override
    protected void onStop() {
        if (status == 0) {
            save = imageAdapter.currentPos();
        } else {
            save = p - slider.getCurrentItem();
        }
        savePuzzelCount(save);
        super.onStop();

    }


    @Override
    public void onDestroy() {
        this.wakeLock.release();
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            flipper.setDisplayedChild(0);
            list();
            status = 0;

        } else {

            flipper.setDisplayedChild(1);
            pag();
            status = 1;

        }
    }

    void displayInterstitialAd() {
      /*  mInterstitialAd.loadAd(new AdRequest.Builder().build());
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }*/
        if (mInterstitialAd != null) {
            mInterstitialAd.show(this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
        }

    }

    public Activity getCurrentActivity() {
        return currentActivity;
    }

    public void setCurrentActivity(Activity activity) {
        currentActivity = activity;
    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v == button1) {
            Intent intent = new Intent(MainActivity.this, Index.class);
            startActivity(intent);
           // displayInterstitialAd();
        }else if (v==buttonprivecy){
            Intent intent=new Intent(MainActivity.this,PrivacyPolicy.class);
            startActivity(intent);
        } else if (v == button2) {
            if (status == 0) {
                save = imageAdapter.currentPos();
            } else {
                save = p - slider.getCurrentItem();
            }
            boolean isInserted = myDB.insertData(save);
            Log.v("save", save + "");

            if (isInserted == true) {
                Toast.makeText(MainActivity.this, "تم حفظ الصفحة", Toast.LENGTH_LONG).show();
                if(button3.getVisibility()==View.GONE){
                    button3.setVisibility(View.VISIBLE);
                }
            } else {
                Toast.makeText(MainActivity.this, "تم حفظ الصفحة سابقاً", Toast.LENGTH_LONG).show();
            }

          //  displayInterstitialAd();
        } else if (v == button3) {
            Intent intent1 = new Intent(MainActivity.this, Favorit.class);
            startActivity(intent1);
          //  displayInterstitialAd();
        } else if (v == button4) {
            Intent intent2 = new Intent(MainActivity.this, About.class);
            startActivity(intent2);
         //   displayInterstitialAd();

        } else if (v == button5) {
            // StartAppAd.showAd(this);

            //    Intent masrysouq = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.masrysouq.com/shop"));

            //    startActivity(masrysouq);

            Intent intent3 = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://play.google.com/store/apps/developer?id=%D8%A3%D8%AD%D9%85%D8%AF%20%D8%B9%D9%88%D8%B6%20%D9%81%D9%83%D8%B1%D9%89"));

            startActivity(intent3);

        } else if (v == button6) {
            Intent intent4 = new Intent(Intent.ACTION_SEND)
                    .setType("text/plain")
                    .putExtra(Intent.EXTRA_TEXT, "السلام عليكم" + "\n" + "https://play.google.com/store/apps/details?id=" + getPackageName());
            Intent.createChooser(intent4, "مشاركة التطبيق");
            startActivity(intent4);

           // displayInterstitialAd();
        } else if (v == button7) {


            Intent intent5 = new Intent(Intent.ACTION_VIEW)
                    .setData(Uri.parse("market://details?id=" + getPackageName()));
            startActivity(intent5);

        //    displayInterstitialAd();
        } else if (v == linearLayout1) {
            linearLayout.setVisibility(View.GONE);
            relativeLayout.setVisibility(View.VISIBLE);
            //Intent intent6 = new Intent(getCurrentActivity(),Brightnes.class);
            //  intent6.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            //  startActivity(intent6);


        } else if (v == exit) {
            relativeLayout.setVisibility(View.GONE);

         //   displayInterstitialAd();
        }
        // displayInterstitialAd();
        //startAppAd.showAd(); // show the ad
    }


}
