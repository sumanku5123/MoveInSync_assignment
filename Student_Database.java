package com.example.move_in_sync;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Student_Database extends SQLiteOpenHelper {

    public static final String Database_Name ="Student_Database";
    public static final String Table_Name ="Student_Info";
    public static final String Col_1 ="ID";
    public static final String Col_2 ="Name";
    public static final String Col_3 ="Marks";
    public static final String Col_4 ="Class";

    public Student_Database(Context context) {
        super(context, Database_Name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " +Table_Name +"(ID INTEGER PRIMARY KEY AUTOINCREMENT , Name TEXT , Marks FLOAT , Class STRING)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+Table_Name);
        onCreate(db);

    }
    public boolean insert_Data(String Name , String Marks , String Class)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_2,Name);
        contentValues.put(Col_3,Marks);
        contentValues.put(Col_4,Class);
        long result = db.insert(Table_Name , null,contentValues);
        if(result == -1)
            return false;
        else
            return true;

    }

    public ArrayList<student> getData()
    {
        ArrayList<student> arrayList = new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Student_Info",null);
        while (cursor.moveToNext()) {

            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String Marks = cursor.getString(2);
            String Class = cursor.getString(3);

            student student = new student( id , name ,Marks , Class , false);
            arrayList.add(student);

        }
        return arrayList;
    }

   public List<student> search(String keyword) {
        List<student> contacts = null;
        try {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + Table_Name + " where " + Col_2 + " like ?", new String[] { "%" + keyword + "%" });
            if (cursor.moveToFirst()) {
                contacts = new ArrayList<student>();
                do {
                    student contact = new student();
                    contact.setId(cursor.getInt(0));
                    contact.setName(cursor.getString(1));
                    contact.setMarks(cursor.getString(2));
                    contact.setStudent_class(cursor.getString(3));
                    contacts.add(contact);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            contacts = null;
        }
        return contacts;
    }
}
