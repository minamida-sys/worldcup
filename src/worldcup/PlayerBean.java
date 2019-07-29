package worldcup;

import java.io.Serializable;

public class PlayerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int playerid;
	private String country;
	private int uni_num;
	private String position;
	private String playername;
	private String club;
	private String birth;
	private int height;
	private int weight;

	public PlayerBean() {
		this.playerid = 0;
		this.country = "";
		this.uni_num = 0;
		this.position = "";
		this.playername = "";
		this.club = "";
		this.birth = "";
		this.height = 0;
		this.weight = 0;
	}

	public int getPlayerid() {
		return playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getUni_num() {
		return uni_num;
	}

	public void setUni_num(int uni_num) {
		this.uni_num = uni_num;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPlayername() {
		return playername;
	}

	public void setPlayername(String playername) {
		this.playername = playername;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}



}
