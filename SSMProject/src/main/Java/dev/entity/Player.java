package dev.entity;

public class Player {

	private long playerId;

	private String name;

	private Sex sex;

	private String teamName;

	private float kd;

	public Player(){

	}

	public Player(long playerId, String name, Sex sex, String teamName, float kd){
		this.playerId = playerId;
		this.name = name;
		this.sex = sex;
		this.teamName = teamName;
		this.kd = kd;
	}

	public Player(long playerId, String name, String teamName, float kd){
		new Player(playerId, name, Sex.secret, teamName, kd);
	}


	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public float getKd() {
		return kd;
	}

	public void setKd(float kd) {
		this.kd = kd;
	}

	@Override
	public String toString() {
		return "Player[ id:" + playerId + " name:" + name + " TeamName:" + teamName + " kd:" + kd +" ]";
	}
}

enum Sex{
	male, female, secret
}
