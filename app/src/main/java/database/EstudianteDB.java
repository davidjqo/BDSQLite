package database;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.*;
import entities.*;
import java.util.*;


public class EstudianteDB extends SQLiteOpenHelper {
    private static String dbName = "EstudianteDB";
    private static String tableName = "estudiante";
    private static String idColumn = "id";
    private static String nombreColumn = "nombre";
    private static String apellidoColumn = "apellido";
    private static String edadColumn = "edad";

    public EstudianteDB(Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tableName + "(" +
                idColumn + " varchar2(10) not null primary key, " +
                nombreColumn + " varchar2(10) not null, " +
                apellidoColumn + " varchar2(10) not null, " +
                edadColumn + " number not null" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + tableName);
        onCreate(db);
    }

    public List<Estudiante> findAll() {
        try {
            List<Estudiante> estudiantes = new ArrayList<Estudiante>();
            SQLiteDatabase db = getWritableDatabase();
            Cursor cursor = db.rawQuery("select * from " + tableName, null);
            if(cursor.moveToFirst()) {
                do {
                    Estudiante estudiante = new Estudiante();
                    estudiante.setId(cursor.getString(0));
                    estudiante.setNombre(cursor.getString(1));
                    estudiante.setApellido(cursor.getString(2));
                    estudiante.setEdad(cursor.getInt(3));
                    estudiantes.add(estudiante);
                } while (cursor.moveToNext());
            }
            db.close();
            return estudiantes;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean create(Estudiante estudiante) {
        try {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(idColumn, estudiante.getId());
            contentValues.put(nombreColumn, estudiante.getNombre());
            contentValues.put(apellidoColumn, estudiante.getApellido());
            contentValues.put(edadColumn, estudiante.getEdad());
            long rows = db.insert(tableName, null, contentValues);
            db.close();
            return rows > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
