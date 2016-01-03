package util;

import model.City;
import model.County;
import model.Province;
import android.text.TextUtils;
import db.CoolWeatherDB;

public class Utility {

	public static synchronized boolean handleProvicesResponse(CoolWeatherDB coolWeatherDB,
			String response){
		if(!TextUtils.isEmpty(response)){
			String[] allProvinces=response.split(",");
			if(allProvinces!=null && allProvinces.length>0){
				for(String p : allProvinces){
					String[] array =p.split("\\|");
					Province province =new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);
					
					coolWeatherDB.saveProvince(province);
				}
				return true;
			}
			
		}
		return false;
	}                   
	
	public static synchronized boolean handleCitiesResponse(CoolWeatherDB coolWeatherDB
			,String response,int provinceId){
		if(!TextUtils.isEmpty(response)){
			String[] allCities = response.split(",");
			if(allCities!=null && allCities.length>0){
				for(String c : allCities){
					String[] array =c.split("\\|");
					City city =new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					city.setProcinceId(provinceId);
					coolWeatherDB.saveCity(city);
				}
				return true;
			}
		}
		return false;
	}
	
	public static synchronized boolean handleCountyReaponse(CoolWeatherDB coolWeatherDB,
		String response, int cityId	){
		if(!TextUtils.isEmpty(response)){
			String[] allCounty = response.split(",");
			if(allCounty!= null && allCounty.length>0){
				for(String c : allCounty){
					String[] array= c.split("\\|");
					County county =new County();
					county.setCountyCode(array[0]);
					county.setCountyName(array[1]);
					county.setCityId(cityId);
					coolWeatherDB.saveCounty(county);
				}
				return true;
			}
		}
		return false;
	}
	
	
}
