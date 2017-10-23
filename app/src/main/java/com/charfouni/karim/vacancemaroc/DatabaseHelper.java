package com.charfouni.karim.vacancemaroc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by karim on 22/09/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DbName="vacancemaroc.db";
    public static String DB_PATH = "/data/data/com.charfouni.karim.vacancemaroc/databases/";
    public SQLiteDatabase myDataBase;
    public static final int Version=1;
    Context context;

    public DatabaseHelper(Context context){
        super(context,DbName,null,Version);
        this.context=context;
    }

    public void createDataBase() throws IOException {

        boolean dbExist = checkDataBase();

        if(dbExist){
            //do nothing - database already exist
        }else{

            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();

            try {

                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copying database");

            }
        }

    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase(){

        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DbName;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch(SQLiteException e){

            //database does't exist yet.

        }

        if(checkDB != null){

            checkDB.close();

        }

        return checkDB != null ? true : false;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException{

        //Open your local db as the input stream
        InputStream myInput = context.getAssets().open(DbName);

        // Path to the just created empty db
        String outFileName = DB_PATH + DbName;

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException{

        //Open the database
        String myPath = DB_PATH + DbName;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {

        if(myDataBase != null)
            myDataBase.close();

        super.close();

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS `Place` ( `id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT, `type` TEXT,`description` TEXT, `city` TEXT,`address` TEXT, `price` REAL, `imageBackground` INTEGER )");
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL("DROP table if exists place");
        }catch (SQLException e){
            e.printStackTrace();
        }
        onCreate(db);

    }

    public void insertRowPlace(String type,String name,String description,String city,String address,Double price,int imageBackground){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("type",type);
        contentValues.put("name",name);
        contentValues.put("city",city);
        contentValues.put("description",description);
        contentValues.put("address",address);
        contentValues.put("price",price);
        contentValues.put("imageBackground",imageBackground);
        db.insert("place",null,contentValues);
    }

    public ArrayList getALLPlaceRecord(){
        ArrayList<Place> places=new ArrayList<Place>();

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor res = db.rawQuery("select * from place", null);
            res.moveToFirst();
            while (res.isAfterLast() == false) {
                places.add(new Place(res.getString(res.getColumnIndex("name")), res.getString(res.getColumnIndex("type")), res.getString(res.getColumnIndex("description")),
                        res.getString(res.getColumnIndex("city")), res.getString(res.getColumnIndex("address")), res.getDouble(res.getColumnIndex("price")),
                        res.getInt(res.getColumnIndex("imageBackground"))));
                res.moveToNext();
            }

        return places;
    }
    public ArrayList getAllHotelsRecord(){
        ArrayList<Hotel> hotels=new ArrayList<Hotel>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from place where type='Hotel'", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            hotels.add(new Hotel(res.getString(res.getColumnIndex("name")), res.getString(res.getColumnIndex("type")), res.getString(res.getColumnIndex("description")),
                    res.getString(res.getColumnIndex("city")), res.getString(res.getColumnIndex("address")), res.getDouble(res.getColumnIndex("price")),
                    res.getInt(res.getColumnIndex("imageBackground"))));
            res.moveToNext();
        }

        return hotels;

    }

    public ArrayList getAllRiadsRecord(){
        ArrayList<Riad> riads=new ArrayList<Riad>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from place where type='Riad'", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            riads.add(new Riad(res.getString(res.getColumnIndex("name")), res.getString(res.getColumnIndex("type")), res.getString(res.getColumnIndex("description")),
                    res.getString(res.getColumnIndex("city")), res.getString(res.getColumnIndex("address")), res.getDouble(res.getColumnIndex("price")),
                    res.getInt(res.getColumnIndex("imageBackground"))));
            res.moveToNext();
        }

        return riads;

    }

    public ArrayList getAllResidencesRecord(){
        ArrayList<Residence> residences=new ArrayList<Residence>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from place where type='Residence'", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            residences.add(new Residence(res.getString(res.getColumnIndex("name")), res.getString(res.getColumnIndex("type")), res.getString(res.getColumnIndex("description")),
                    res.getString(res.getColumnIndex("city")), res.getString(res.getColumnIndex("address")), res.getDouble(res.getColumnIndex("price")),
                    res.getInt(res.getColumnIndex("imageBackground"))));
            res.moveToNext();
        }

        return residences;

    }

    public ArrayList getAllAubergesRecord(){
        ArrayList<Auberge> auberges=new ArrayList<Auberge>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from place where type='Auberge'", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            auberges.add(new Auberge(res.getString(res.getColumnIndex("name")), res.getString(res.getColumnIndex("type")), res.getString(res.getColumnIndex("description")),
                    res.getString(res.getColumnIndex("city")), res.getString(res.getColumnIndex("address")), res.getDouble(res.getColumnIndex("price")),
                    res.getInt(res.getColumnIndex("imageBackground"))));
            res.moveToNext();
        }

        return auberges;

    }

    public ArrayList getAllRestaurantsRecord(){
        ArrayList<Restaurant> restaurants=new ArrayList<Restaurant>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from place where type='Restaurant'", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            restaurants.add(new Restaurant(res.getString(res.getColumnIndex("name")), res.getString(res.getColumnIndex("type")), res.getString(res.getColumnIndex("description")),
                    res.getString(res.getColumnIndex("city")), res.getString(res.getColumnIndex("address")), res.getDouble(res.getColumnIndex("price")),
                    res.getInt(res.getColumnIndex("imageBackground"))));
            res.moveToNext();
        }

        return restaurants;

    }
    public ArrayList getAllCafesRecord(){
        ArrayList<Cafe> cafes=new ArrayList<Cafe>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from place where type='Cafe'", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            cafes.add(new Cafe(res.getString(res.getColumnIndex("name")), res.getString(res.getColumnIndex("type")), res.getString(res.getColumnIndex("description")),
                    res.getString(res.getColumnIndex("city")), res.getString(res.getColumnIndex("address")), res.getDouble(res.getColumnIndex("price")),
                    res.getInt(res.getColumnIndex("imageBackground"))));
            res.moveToNext();
        }

        return cafes;

    }
    public ArrayList getAllPiscinesRecord(){
        ArrayList<Piscine> piscines=new ArrayList<Piscine>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from place where type='Piscine'", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            piscines.add(new Piscine(res.getString(res.getColumnIndex("name")), res.getString(res.getColumnIndex("type")), res.getString(res.getColumnIndex("description")),
                    res.getString(res.getColumnIndex("city")), res.getString(res.getColumnIndex("address")), res.getDouble(res.getColumnIndex("price")),
                    res.getInt(res.getColumnIndex("imageBackground"))));
            res.moveToNext();
        }

        return piscines;

    }
    public ArrayList getAllCinemasRecord(){
        ArrayList<Cinema> cinemas=new ArrayList<Cinema>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from place where type='Cinema'", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            cinemas.add(new Cinema(res.getString(res.getColumnIndex("name")), res.getString(res.getColumnIndex("type")), res.getString(res.getColumnIndex("description")),
                    res.getString(res.getColumnIndex("city")), res.getString(res.getColumnIndex("address")), res.getDouble(res.getColumnIndex("price")),
                    res.getInt(res.getColumnIndex("imageBackground"))));
            res.moveToNext();
        }

        return cinemas;

    }

    public ArrayList getAllInternationalBrnadRecord(){
        ArrayList<InternationalBrand> internationalBrands=new ArrayList<InternationalBrand>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from place where type='International Brand'", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            internationalBrands.add(new InternationalBrand(res.getString(res.getColumnIndex("name")), res.getString(res.getColumnIndex("type")), res.getString(res.getColumnIndex("description")),
                    res.getString(res.getColumnIndex("city")), res.getString(res.getColumnIndex("address")), res.getDouble(res.getColumnIndex("price")),
                    res.getInt(res.getColumnIndex("imageBackground"))));
            res.moveToNext();
        }

        return internationalBrands;

    }

    public ArrayList getAllLocalProductsRecord(){
        ArrayList<LocalProduct> localProducts=new ArrayList<LocalProduct>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from place where type='Local Product'", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            localProducts.add(new LocalProduct(res.getString(res.getColumnIndex("name")), res.getString(res.getColumnIndex("type")), res.getString(res.getColumnIndex("description")),
                    res.getString(res.getColumnIndex("city")), res.getString(res.getColumnIndex("address")), res.getDouble(res.getColumnIndex("price")),
                    res.getInt(res.getColumnIndex("imageBackground"))));
            res.moveToNext();
        }

        return localProducts;

    }

    public ArrayList getAllArtisanatMarocaineRecord(){
        ArrayList<ArtisanatMarocaine> artisanatMarocaines=new ArrayList<ArtisanatMarocaine>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from place where type='Artisanat Marocaine'", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            artisanatMarocaines.add(new ArtisanatMarocaine(res.getString(res.getColumnIndex("name")), res.getString(res.getColumnIndex("type")), res.getString(res.getColumnIndex("description")),
                    res.getString(res.getColumnIndex("city")), res.getString(res.getColumnIndex("address")), res.getDouble(res.getColumnIndex("price")),
                    res.getInt(res.getColumnIndex("imageBackground"))));
            res.moveToNext();
        }

        return artisanatMarocaines;

    }

    public ArrayList getAllLocationVoitureRecord(){
        ArrayList<LocationVoiture> locationVoitures=new ArrayList<LocationVoiture>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from place where type='Location Voiture'", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            locationVoitures.add(new LocationVoiture(res.getString(res.getColumnIndex("name")), res.getString(res.getColumnIndex("type")), res.getString(res.getColumnIndex("description")),
                    res.getString(res.getColumnIndex("city")), res.getString(res.getColumnIndex("address")), res.getDouble(res.getColumnIndex("price")),
                    res.getInt(res.getColumnIndex("imageBackground"))));
            res.moveToNext();
        }

        return locationVoitures;

    }

    public ArrayList getAllAgenceVoyageRecord(){
        ArrayList<AgenceVoyage> agenceVoyages=new ArrayList<AgenceVoyage>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from place where type='Agence Voyage'", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            agenceVoyages.add(new AgenceVoyage(res.getString(res.getColumnIndex("name")), res.getString(res.getColumnIndex("type")), res.getString(res.getColumnIndex("description")),
                    res.getString(res.getColumnIndex("city")), res.getString(res.getColumnIndex("address")), res.getDouble(res.getColumnIndex("price")),
                    res.getInt(res.getColumnIndex("imageBackground"))));
            res.moveToNext();
        }
        return agenceVoyages;

    }

    public ArrayList getAllGuideTouristiquerecord(){
        ArrayList<GuideTouristique> guideTouristiques=new ArrayList<GuideTouristique>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from place where type='Guide Touristique'", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            guideTouristiques.add(new GuideTouristique(res.getString(res.getColumnIndex("name")), res.getString(res.getColumnIndex("type")), res.getString(res.getColumnIndex("description")),
                    res.getString(res.getColumnIndex("city")), res.getString(res.getColumnIndex("address")), res.getDouble(res.getColumnIndex("price")),
                    res.getInt(res.getColumnIndex("imageBackground"))));
            res.moveToNext();
        }
        return guideTouristiques;

    }
    public ArrayList getAllAvisiterrecord(){
        ArrayList<Avisiter> avisiters=new ArrayList<Avisiter>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from place where type='A Visiter'", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            avisiters.add(new Avisiter(res.getString(res.getColumnIndex("name")), res.getString(res.getColumnIndex("type")), res.getString(res.getColumnIndex("description")),
                    res.getString(res.getColumnIndex("city")), res.getString(res.getColumnIndex("address")), res.getDouble(res.getColumnIndex("price")),
                    res.getInt(res.getColumnIndex("imageBackground"))));
            res.moveToNext();
        }
        return avisiters;

    }

    public ArrayList getAllRecord(){
        ArrayList<Place> places=new ArrayList<Place>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from place ORDER BY price", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            places.add(new Place(res.getString(res.getColumnIndex("name")), res.getString(res.getColumnIndex("type")), res.getString(res.getColumnIndex("description")),
                    res.getString(res.getColumnIndex("city")), res.getString(res.getColumnIndex("address")), res.getDouble(res.getColumnIndex("price")),
                    res.getInt(res.getColumnIndex("imageBackground"))));
            res.moveToNext();
        }
        return places;

    }
    public void deleteAllrecords(){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("delete from place");
    }
    public ArrayList getAllMarrakechRecords(){
        ArrayList<Place> places=new ArrayList<Place>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from place where city='Marrakech' ORDER BY price", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            places.add(new Place(res.getString(res.getColumnIndex("name")), res.getString(res.getColumnIndex("type")), res.getString(res.getColumnIndex("description")),
                    res.getString(res.getColumnIndex("city")), res.getString(res.getColumnIndex("address")), res.getDouble(res.getColumnIndex("price")),
                    res.getInt(res.getColumnIndex("imageBackground"))));
            res.moveToNext();
        }
        return places;

    }
    public ArrayList getAllCasablancaRecords(){
        ArrayList<Place> places=new ArrayList<Place>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from place where city='Casablanca' ORDER BY price", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            places.add(new Place(res.getString(res.getColumnIndex("name")), res.getString(res.getColumnIndex("type")), res.getString(res.getColumnIndex("description")),
                    res.getString(res.getColumnIndex("city")), res.getString(res.getColumnIndex("address")), res.getDouble(res.getColumnIndex("price")),
                    res.getInt(res.getColumnIndex("imageBackground"))));
            res.moveToNext();
        }
        return places;

    }



}
