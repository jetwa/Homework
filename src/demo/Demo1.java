package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.*;

class Weather {
	private String cityno;
	private String week;
	private String winp;
	private String winpid;
	private String citynm;
	private String windid;
	private String cityid;
	private String humi_high;
	private String weatid;
	private String weaid;
	private String humi_low;
	private String temperature;
	private String weather;
	private String days;
	private String humidity;
	private String weatid1;
	private String temp_low;
	private String wind;

	public Weather() {
		super();
	}

	public void setCityno(String cityno) {
		this.cityno = cityno;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public void setWinp(String winp) {
		this.winp = winp;
	}

	public void setWinpid(String winpid) {
		this.winpid = winpid;
	}

	public void setCitynm(String citynm) {
		this.citynm = citynm;
	}

	public void setDindid(String dindid) {
		this.windid = dindid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public void setHumi_high(String humi_high) {
		this.humi_high = humi_high;
	}

	public void setWeatid(String weatid) {
		this.weatid = weatid;
	}

	public void setWeaid(String weaid) {
		this.weaid = weaid;
	}

	public void setHumi_low(String humi_low) {
		this.humi_low = humi_low;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public void setWeatid1(String weatid1) {
		this.weatid1 = weatid1;
	}

	public void setTemp_low(String temp_low) {
		this.temp_low = temp_low;
	}

	public void setWind(String wind) {
		this.wind = wind;
	}

	@Override
	public String toString() {
		return "weather [cityno=" + cityno + ", week=" + week + ", winp=" + winp + ", winpid=" + winpid + ", citynm="
				+ citynm + ", windid=" + windid + ", cityid=" + cityid + ", humi_high=" + humi_high + ", weatid="
				+ weatid + ", weaid=" + weaid + ", humi_low=" + humi_low + ", temperature=" + temperature + ", weather="
				+ weather + ", days=" + days + ", humidity=" + humidity + ", weatid1=" + weatid1 + ", temp_low="
				+ temp_low + ", wind=" + wind + "]";
	}

}

public class Demo1 {
	public static void main(String[] args) {

		try {
			File file = new File("resource/weather");
			FileReader ir = new FileReader(file);
			BufferedReader br = new BufferedReader(ir);

			StringBuilder sBuilder = new StringBuilder();
			String str = "";

			while (null != (str = br.readLine())) {
				sBuilder.append(str);
			}

			JSONObject obj1 = new JSONObject(sBuilder.toString());

			System.out.println(obj1);

			System.out.println(obj1.getString("success"));

			JSONArray objArr = obj1.getJSONArray("result");

			String[] weathers = new String[7];

			JSONObject[] objs = new JSONObject[7];

			Weather[] w = new Weather[7];

			for (int i = 0; i < w.length; i++) {
				w[i] = new Weather();
			}

			for (int i = 0; i < weathers.length; i++) {
				weathers[i] = objArr.get(i).toString();
				objs[i] = new JSONObject(weathers[i]);
				w[i].setCityno(objs[i].getString("cityno"));
				w[i].setWeek(objs[i].getString("week"));
				w[i].setWinp(objs[i].getString("winp"));
				w[i].setWinpid(objs[i].getString("winpid"));
				w[i].setCitynm(objs[i].getString("citynm"));
				w[i].setDindid(objs[i].getString("windid"));
				w[i].setCityid(objs[i].getString("cityid"));
				w[i].setHumi_high(objs[i].getString("humi_high"));
				w[i].setWeatid(objs[i].getString("weatid"));
				w[i].setWeaid(objs[i].getString("weaid"));
				w[i].setHumi_low(objs[i].getString("humi_low"));
				w[i].setTemperature(objs[i].getString("temperature"));
				w[i].setWeather(objs[i].getString("weather"));
				w[i].setDays(objs[i].getString("days"));
				w[i].setHumidity(objs[i].getString("humidity"));
				w[i].setWeatid1(objs[i].getString("weatid1"));
				w[i].setTemp_low(objs[i].getString("temp_low"));
				w[i].setWind(objs[i].getString("wind"));
				System.out.println(w[i]);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
