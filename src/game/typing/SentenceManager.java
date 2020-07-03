package game.typing;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SentenceManager {
	private List<Sentence> sentences;
	private static SentenceManager instance;


//	コンストラクタ
	SentenceManager() {
		this.sentences = this.loadSentences();
	}


//	タイピング情報読み込み
//	@return タイピングリスト
	private List<Sentence> loadSentences() {
		List<Sentence> list = new ArrayList<Sentence>();

		try {
//			csvファイルの読み込み InputStream = バイト率を読み込むオブジェクト
			InputStream stream = this.getClass().getResourceAsStream("sentences.csv");
//			ExcelからCSV形式で保存すると、それを認識するためのバイト列が先頭に3文字記述されるものを飛ばす
			stream.skip(3);
//			読み込めるようにBufferedReaderに変換
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

			String line;
//			タイピング情報が最後まで読み込んでいなかったら
			while((line = reader.readLine()) != null) {
//				カンマで区って一文ずつ取得
				StringTokenizer tokenizer = new StringTokenizer(line, ",");

//				もし区切り文字がまだあれば
				if(tokenizer.hasMoreTokens()) {
//					区切り文字から区切り文字の間を取得
					String text = tokenizer.nextToken();
//					単語を設定
					Sentence sentence = new Sentence(text);

//					もし区切り文字がまだあればさらに
					while(tokenizer.hasMoreTokens()) {
//						区切り文字から区切り文字の間を取得
						String typing = tokenizer.nextToken();
//						タイピング文字列にタイピング文字を追加する
						sentence.addTyping(typing);
					}
//					タイピング文字列をリストに追加
					list.add(sentence);
				}
			}
			reader.close();
//		例外処理
		} catch(Exception e) {
//			エラーを表示
			e.printStackTrace();
		}
		return list;
	}

//	タイピング情報を無作為に取り出す
//	@return 無作為なタイピング情報
	public Sentence getRandomSentence() {
		int r = (int)(Math.random() * this.sentences.size());
		Sentence sentence = this.sentences.get(r);
		return sentence;

//		Randomクラス
//		Random random = new Random();
//		int index = random.nextInt(this.sentences.size());
//		Sentence s = this.sentences.get(index);
//		return s;

//		shuffle
//		Collections.shuffle(this.sentences);
//		Sentence sentence = this.sentences.get(0);
//		return sentence;

	}


//	SentenceManager オブジェクト取得
//	@return SentenceManager オブジェクト(シングルトン・クラス)
	public static SentenceManager getInstance() {
		if(SentenceManager.instance == null) {
			SentenceManager.instance = new SentenceManager();
		}
		return SentenceManager.instance;
	}

}
