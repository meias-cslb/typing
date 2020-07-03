package game.typing;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
	private String text;
	private List<String> typingList;

//	@param text 表示文字列
	public Sentence(String text) {
		this.typingList = new ArrayList<String>();
		this.setText(text);
	}

	public String getText() {
		return this.text;
	}

	private void setText(String text) {
		this.text = text;
	}

//	最初のタイピング文字列を表示
//	@return 最初のタイピング文字列
	public String getFirstTyping() {
		return this.typingList.get(0);
	}

//	タイピン部文字列を追加
//	@param typing タイピング文字列
	public void addTyping(String typing) {
		this.typingList.add(typing);
	}

//	指定文字列がタイピング文字に含まれるか判定
//	@param typing 指定文字列
//	@return 指定文字列がタイピング文字に含まれていれば true
	public boolean contains(String typing) {
		boolean contained = this.typingList.contains(typing);
		return contained;
	}

}
