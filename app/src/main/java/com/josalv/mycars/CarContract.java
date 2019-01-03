package com.josalv.mycars;

import android.net.Uri;
import android.provider.BaseColumns;

public class CarContract {

    public static final String DB_NAME = "mycars.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE = "car";
    public static final String DEFAULT_SORT = Column.ID + " DESC";

    public static final String AUTHORITY = "com.alvvela.yambaalvaro.StatusProvider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE);
    public static final int CAR_ITEM = 1;
    public static final int CAR_DIR = 2;

    public class Column {
        public static final String ID = BaseColumns._ID;
        public static final String MARCA = "marca";
        public static final String MODELO = "modelo";
        public static final String TIPO = "tipo";
        public static final String COLOR = "color";
        public static final String DESCRIPCION = "descripcion";
    }
}
