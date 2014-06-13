package co.edu.udea.compumovil.grupo11.yamba.database.contract;

import android.net.Uri;
import android.provider.BaseColumns;

public class StatusContract {

	public static final String DB_NAME = "Status_Timeline.db";
	public static final int DB_VERSION = 1;
	public static final String TABLE = "STATUS";
	public static final String DEFAULT_SORT = Column.CREATED_AT
			+ " DESC";

	public static final String AUTHORITY = "co.edu.udea.compumovil.grupo11.yamba.provider.StatusContentProvider";
	public static final String STATUS_LEVEL = "status";
	public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY
			+ "/" + STATUS_LEVEL);
	public static final int STATUS_ITEM = 1;
	public static final int STATUS_DIR = 2;
	public static final String STATUS_TYPE_ITEM = "vnd.android.cursor.item/vnd.co.edu.udea.compumovil.grupo11.yamba.contentprovider.status";
	public static final String STATUS_TYPE_DIR = "vnd.android.cursor.dir/vnd.co.edu.udea.compumovil.grupo11.yamba.contentprovider.status";

	private StatusContract() {
		super();
	}

	public class Column {

		public static final String ID = BaseColumns._ID;
		public static final String USER = "USER";
		public static final String MESSAGE = "MESSAGE";
		public static final String CREATED_AT = "CREATED_AT";

		private Column() {
			super();
		}
	}
}