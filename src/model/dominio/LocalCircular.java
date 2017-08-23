package model.dominio;

import java.util.Date;


public class LocalCircular {
	
	int id;
	Date utf_time;
	int altitude;
	float diracao;
	float velocidade;
	int satelites;
	float latitude;
	float longitude;
	
	public LocalCircular(int id, Date utf_time, int altitude, float diracao, float velocidade, int satelites,
			float latitude, float longitude) {
		super();
		this.id = id;
		this.utf_time = utf_time;
		this.altitude = altitude;
		this.diracao = diracao;
		this.velocidade = velocidade;
		this.satelites = satelites;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public LocalCircular() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getUtf_time() {
		return utf_time;
	}

	public void setUtf_time(Date utf_time) {
		this.utf_time = utf_time;
	}

	public int getAltitude() {
		return altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	public float getDiracao() {
		return diracao;
	}

	public void setDiracao(float diracao) {
		this.diracao = diracao;
	}

	public float getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(float velocidade) {
		this.velocidade = velocidade;
	}

	public int getSatelites() {
		return satelites;
	}

	public void setSatelites(int satelites) {
		this.satelites = satelites;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	
	
}
