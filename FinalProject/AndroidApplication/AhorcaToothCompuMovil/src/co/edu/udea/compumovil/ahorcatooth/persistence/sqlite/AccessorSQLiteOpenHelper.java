package co.edu.udea.compumovil.ahorcatooth.persistence.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import co.edu.udea.compumovil.ahorcatooth.persistence.contract.CategoryContract;
import co.edu.udea.compumovil.ahorcatooth.persistence.contract.HangmanWordContract;
import co.edu.udea.compumovil.ahorcatooth.persistence.contract.LanguagesContract;
import co.edu.udea.compumovil.ahorcatooth.persistence.contract.PersistanceContract;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public class AccessorSQLiteOpenHelper extends SQLiteOpenHelper {

	private static final String TAG = AccessorSQLiteOpenHelper.class
			.getSimpleName();

	public AccessorSQLiteOpenHelper(Context context) {
		super(context, PersistanceContract.DATABASE_NAME, null,
				PersistanceContract.DATABASE_VERSION);
	}

	@Override()
	public void onCreate(SQLiteDatabase db) {
		String languagesTableSQLCreator = String
				.format("CREATE TABLE %s (%s TEXT PRIMARY KEY, %s TEXT NOT NULL, %s TEXT)",
						LanguagesContract.TABLE_NAME,
						LanguagesContract.Column.ISO_CODE,
						LanguagesContract.Column.TONGUE,
						LanguagesContract.Column.DESCRIPTION);
		String categoryTableSQLCreator = String
				.format("CREATE TABLE %s (%s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT, PRIMARY KEY (%s, %s), FOREIGN KEY (%s) REFERENCES %s(%s))",
						CategoryContract.TABLE_NAME,
						CategoryContract.Column.CATEGORY_NAME,
						CategoryContract.Column.LANGUAGES_ISO_CODE,
						CategoryContract.Column.IMAGE_NAME,
						CategoryContract.Column.DESCRIPTION,
						CategoryContract.Column.CATEGORY_NAME,
						CategoryContract.Column.LANGUAGES_ISO_CODE,
						CategoryContract.Column.LANGUAGES_ISO_CODE,
						LanguagesContract.TABLE_NAME,
						LanguagesContract.Column.ISO_CODE);

		String hangmanWordTableSQLCreator = String
				.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s TEXT NOT NULL, %s TEXT, %s TEXT NOT NULL, %s TEXT NOT NULL, FOREIGN KEY (%s) REFERENCES %s(%s), FOREIGN KEY (%s) REFERENCES %s(%s))",
						HangmanWordContract.TABLE_NAME,
						HangmanWordContract.Column.ID,
						HangmanWordContract.Column.WORD_NAME,
						HangmanWordContract.Column.DESCRIPTION,
						HangmanWordContract.Column.CATEGORY_NAME,
						HangmanWordContract.Column.LANGUAGES_ISO_CODE,
						HangmanWordContract.Column.CATEGORY_NAME,
						CategoryContract.TABLE_NAME,
						CategoryContract.Column.CATEGORY_NAME,
						HangmanWordContract.Column.LANGUAGES_ISO_CODE,
						CategoryContract.TABLE_NAME,
						CategoryContract.Column.LANGUAGES_ISO_CODE);

		Log.d(TAG, languagesTableSQLCreator);
		Log.d(TAG, categoryTableSQLCreator);
		Log.d(TAG, hangmanWordTableSQLCreator);

		db.execSQL(languagesTableSQLCreator);
		db.execSQL(categoryTableSQLCreator);
		db.execSQL(hangmanWordTableSQLCreator);
	}

	@Override()
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newViersion) {
		db.execSQL(String.format("DROP TABLE IF EXITS %s",
				HangmanWordContract.TABLE_NAME));
		db.execSQL(String.format("DROP TABLE IF EXITS %s",
				CategoryContract.TABLE_NAME));
		db.execSQL(String.format("DROP TABLE IF EXITS %s",
				LanguagesContract.TABLE_NAME));

		this.onCreate(db);
	}
}