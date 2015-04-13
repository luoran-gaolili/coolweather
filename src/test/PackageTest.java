package test;

import db.CoolWeatherDB;
import db.CoolWeatherOpenHelper;
import android.test.AndroidTestCase;

public class PackageTest extends AndroidTestCase {
	public void testCreat() {
		CoolWeatherOpenHelper cool = new CoolWeatherOpenHelper(getContext(),
				"cool_weather", null, 1);
		cool.getWritableDatabase();
	}

	public void testAdd() {
		CoolWeatherDB db = new CoolWeatherDB(getContext());
		db.add();
	}

	public void testLoadProvince() {
		CoolWeatherDB db = new CoolWeatherDB(getContext());
		db.loadProvince();
	}

}
