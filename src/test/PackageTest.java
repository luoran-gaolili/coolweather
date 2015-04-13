package test;

import db.CoolWeatherOpenHelper;
import android.test.AndroidTestCase;

public class PackageTest extends AndroidTestCase {
	public void testCreat() {
		CoolWeatherOpenHelper cool = new CoolWeatherOpenHelper(getContext(),
				"cool_weather", null, 1);
		cool.getWritableDatabase();
	}

}
