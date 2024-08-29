package naser.badr.ana.elraees;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class Shard extends AppCompatActivity {
      String MY_PREFS_NAME = "savefil";
      String PUZZEL_COUNT = "currentPag";
   String MY_PREFS_NAME2 = "setting2";
    String PUZZEL_COUNT2 = "puzzel_count2";
    String r = "brightness";
    String mypref = "myPref";
    String isdark = "isDark";
    // Context context;
    /*public Shard(Context context) {
        super(context);
        this.context=context;
    }




    @Override
    public Adapter getAdapter() {
        return null;
    }

    @Override
    public void setAdapter(Adapter adapter) {

    }

    @Override
    public View getSelectedView() {
        return null;
    }

    @Override
    public void setSelection(int position) {

    }*/
     void savePuzzelCount(int i) {
        SharedPreferences share=getSharedPreferences(MY_PREFS_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE).edit();
         editor.putInt(PUZZEL_COUNT, i);
         editor.apply();
        return;
    }
    int getSavedPuzzelCount() {
        SharedPreferences share= getSharedPreferences(MY_PREFS_NAME,Context.MODE_PRIVATE);
        return  share.getInt(PUZZEL_COUNT, 0);
    }

    void savePuzzelCount2(int i) {
        SharedPreferences sharedPreferences2=getSharedPreferences(MY_PREFS_NAME2,Context.MODE_PRIVATE);
        SharedPreferences.Editor pen2 = getSharedPreferences(MY_PREFS_NAME2, Context.MODE_PRIVATE).edit();
        pen2.putInt(PUZZEL_COUNT2, i);
        pen2.apply();
        return;
    }
    int getSavedPuzzelCount2() {
        SharedPreferences sharedPreferences2= getSharedPreferences(MY_PREFS_NAME2,Context.MODE_PRIVATE);
        return  sharedPreferences2.getInt(PUZZEL_COUNT2, getSavedPuzzelCount());
    }



    void setBrightness(int alpha) {
        SharedPreferences share=getSharedPreferences(MY_PREFS_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE).edit();
        editor.putInt(r, alpha);
        editor.apply();
        return;
    }
    int getIntPreference() {
        SharedPreferences share= getSharedPreferences(MY_PREFS_NAME,Context.MODE_PRIVATE);
        return  share.getInt(r, 0);
    }

    void saveThemeStatePref(boolean isDark) {

        SharedPreferences pref = getSharedPreferences(mypref,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(isdark,isDark);
        editor.apply();
    }

    boolean getThemeStatePref () {

        SharedPreferences pref = getApplicationContext().getSharedPreferences(mypref,MODE_PRIVATE);
        boolean isDark = pref.getBoolean(isdark,false) ;
        return isDark;

    }


/*
    public void senddata (int s){

        pen.putInt("name",s);
        pen.commit();
    }


    public int getdata (String k){
        return sharedPreferences.getInt(k,0);
    }
*/




  /*
    private static String packageName = "";

    public static String getPackageName() {
        return packageName;
    }

    public static int getIntPreference(String name) {
        SharedPreferences shared = context().getSharedPreferences("savefile" , Context.MODE_PRIVATE);

        return shared.getInt(name, 0) ;

        //getApplicationContext().getSharedPreferences(getPackageName(), 0).getInt(name, defaultValue);
       // return context().getSharedPreferences(getPackageName(), 0).getInt(name, defaultValue);
    }

    private static Context context() {
        return  context ;
    }

    public static void setIntPreference(String name, int value) {

        SharedPreferences shared = context().getSharedPreferences("savefile" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();

        editor.putInt(name, value);
        editor.apply();
        return;

        //context().getSharedPreferences(getPackageName(), 0).edit().putInt(name, value).commit();
    }

    public static void setCurrentPage(int page) {
        setIntPreference("currentPage", page);
    }

    public static int getCurrentPage() {
        return getIntPreference("currentPage");
    }*/
}
