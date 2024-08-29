package naser.badr.ana.elraees;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ahmed on 4/21/2016.
 */
public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "favorit.dp" ;
    public static final String TABLE_NAME = "page_table";
    public static final String COL_1 = "PAGE_NO";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "( PAGE_NO INTEGER PRIMARY KEY)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData( int page)
    {

        SQLiteDatabase dp=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1, page);
        Long result =  dp.insert(TABLE_NAME, null, contentValues);
        if(-1 == result)
            return  false;
        else
            return true;
    }
    public Cursor getAllData()
    {
        SQLiteDatabase dp=this.getWritableDatabase();
        Cursor res=dp.rawQuery("select * from "+ TABLE_NAME, null);
        return res;
    }

    public Integer deleteData(String id)
    {
        SQLiteDatabase dp=this.getWritableDatabase();
        return dp.delete(TABLE_NAME, "PAGE_NO= ?", new String[]{id});
    }

}