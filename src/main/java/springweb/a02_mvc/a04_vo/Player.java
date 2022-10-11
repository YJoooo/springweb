package springweb.a02_mvc.a04_vo;

public class Player {
	private String player;
	private int record;
	public Player() {
		// TODO Auto-generated constructor stub
	}
	public Player(String player, int record) {
		super();
		this.player = player;
		this.record = record;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public int getRecord() {
		return record;
	}
	public void setRecord(int record) {
		this.record = record;
	}
	
}
