package co.project;

public class Board {
	private String boardpostnum;
	private String boardtitle;
	private String boarddetail;
	private String boardviews;
	
	public String getBoardpostnum() {
		return boardpostnum;
	}
	public void setBoardpostnum(String boardpostnum) {
		this.boardpostnum = boardpostnum;
	}
	public String getBoardtitle() {
		return boardtitle;
	}
	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}
	public String getBoarddetail() {
		return boarddetail;
	}
	public void setBoarddetail(String boarddetail) {
		this.boarddetail = boarddetail;
	}
	public String getBoardviews() {
		return boardviews;
	}
	public void setBoardviews(String boardviews) {
		this.boardviews = boardviews;
	}
	@Override
	public String toString() {
		return String.format("3%d %4s $-12s %5d", boardpostnum, boardtitle, boarddetail, boardviews);
	}
}//