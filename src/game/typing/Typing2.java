package game.typing;

import java.util.Scanner;

public class Typing2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("【RADWIMPS】曲名タイピング!");
		System.out.println("始まるよ！Enterを押して！");
		scanner.nextLine();

		start(scanner);

		scanner.close();

	}

	private static void start(Scanner scanner) {
//		唯一のオブジェクトの生成方法(new できない)
		SentenceManager manager = SentenceManager.getInstance();

//		正解数
		int count = 0;

//		60秒設定
		double countTime = 60;
//		開始時刻を取得
		long startTime = System.currentTimeMillis();

//		時間差の準備
		double second = 0;
//		残り時間の準備
		double lag = 0;

//		制限時間60秒まで繰り返す
		while(true) {
//			タイピングリストを無作為に取得
			Sentence sentence = manager.getRandomSentence();
//			タイピングのための文字列を表示
			System.out.println(sentence.getText() + "(" + sentence.getFirstTyping() + ")");

			String line = null;

//			入力されていなければ
			if(line == null) {

//				入力文字を取得
				line = scanner.nextLine();

				if(sentence.contains(line)) {
					System.out.println("○");
					count++;
				} else {
					System.out.println("×");
				}
			}

//			問題を解いた時間を取得
			long endTime = System.currentTimeMillis();
//			スタート時間との差を計算
			second = (double)(endTime - startTime) / 1000.0;

//			残り時間の計算
			lag = countTime - second;

//			残り時間が0秒より小さければ
			if(lag < 0) {
//				問題を終了
				break;
			}

//			残り時間を表示
			System.out.println(
					String .format("残り%.2f秒！", lag)
					);

		}

//		60秒たったら終わり
		System.out.println("おわり！");

//		正解数を表示
		System.out.println("正解数：" + count);

	}

}
