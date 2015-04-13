package db;

import java.util.ArrayList;
import java.util.List;

import model.City;
import model.County;
import model.Province;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CoolWeatherDB {
	CoolWeatherOpenHelper openHelper;
	SQLiteDatabase base;

	public CoolWeatherDB(Context context) {
		openHelper = new CoolWeatherOpenHelper(context, "cool_weather", null, 1);
	}

	public void add() {
		base = openHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("id", 1);
		values.put("province_name", "安徽");
		values.put("province_code", "21");
		base.insert("Province", null, values);

	}

	/**
	 * 把从服务器返回来的数据存储到数据库中
	 * 
	 * @param province
	 */
	public void saveProvince(Province province) {
		if (province != null) {
			ContentValues values = new ContentValues();
			values.put("id", province.getId());
			values.put("province_name", province.getProvinceName());
			values.put("province_code", province.getProvinceCode());
			base = openHelper.getWritableDatabase();
			base.insert("Province", null, values);
		}
	}

	/**
	 * 从数据库去读全国多有的省份信息
	 * 
	 * @return
	 */
	public List<Province> loadProvince() {
		base = openHelper.getReadableDatabase();
		Cursor cursor = base.query("Province", null, null, null, null, null,
				null);
		List<Province> list = new ArrayList<Province>();
		while (cursor.moveToNext()) {
			Province province = new Province();
			int id = cursor.getInt(cursor.getColumnIndex("id"));
			String provinceName = cursor.getString(cursor
					.getColumnIndex("province_name"));
			String provinceCode = cursor.getString(cursor
					.getColumnIndex("province_code"));
			province.setId(id);
			province.setProvinceName(provinceName);
			province.setProvinceCode(provinceCode);
			list.add(province);

		}
		cursor.close();
		return list;

	}

	/**
	 * 把从服务器返回的数据添加到数据库
	 * 
	 * @param city
	 */
	public void saveCity(City city) {
		base = openHelper.getWritableDatabase();
		if (city != null) {
			ContentValues values = new ContentValues();
			values.put("id", city.getId());
			values.put("city_name", city.getCityName());
			values.put("city_code", city.getCityCode());
			values.put("province_id", city.getProvinceId());
			base.insert("City", null, values);
		}
	}

	/**
	 * 从数据库查询某省的所有市信息
	 * 
	 * @param provinceId
	 * @return
	 */
	public List<City> loadCity(int provinceId) {
		base = openHelper.getReadableDatabase();
		Cursor cursor = base.query("City", null, "province_id=?",
				new String[] { String.valueOf(provinceId) }, null, null, null);
		List<City> list = new ArrayList<City>();
		while (cursor.moveToNext()) {
			int id = cursor.getInt(cursor.getColumnIndex("id"));
			String cityName = cursor.getString(cursor
					.getColumnIndex("city_name"));
			String cityCode = cursor.getString(cursor
					.getColumnIndex("city_code"));
			int provinceId1 = cursor.getInt(cursor
					.getColumnIndex("province_id"));
			City city = new City();
			city.setId(id);
			city.setCityName(cityName);
			city.setCityCode(cityCode);
			city.setProvinceId(provinceId1);
			list.add(city);
		}
		cursor.close();
		return list;
	}

	/**
	 * 把从服务器返回的数据添加到数据库
	 * 
	 * @param county
	 */
	public void saveCounty(County county) {
		base = openHelper.getWritableDatabase();
		if (county != null) {
			ContentValues values = new ContentValues();
			values.put("id", county.getId());
			values.put("county_name", county.getCountyName());
			values.put("county_code", county.getCountyCode());
			values.put("city_id", county.getCityId());
			base.insert("County", null, values);
		}
	}

	/**
	 * 从数据库中读取某市下的所有县信息
	 * 
	 * @param cityId
	 * @return
	 */
	public List<County> loadCounty(int cityId) {
		base = openHelper.getWritableDatabase();
		Cursor cursor = base.query("County", null, "city_id=?",
				new String[] { String.valueOf(cityId) }, null, null, null);
		List<County> list = new ArrayList<County>();
		while (cursor.moveToNext()) {
			int id = cursor.getInt(cursor.getColumnIndex("id"));
			String countyName = cursor.getColumnName(cursor
					.getColumnIndex("county_name"));
			String countyCode = cursor.getString(cursor
					.getColumnIndex("county_code"));
			int cityId1 = cursor.getInt(cursor.getColumnIndex("city_id"));
			County county = new County();
			county.setId(id);
			county.setCountyName(countyName);
			county.setCountyCode(countyCode);
			county.setCityId(cityId1);
			list.add(county);
		}
		cursor.close();
		return list;
	}

}
