package game.typing;

import java.util.Scanner;

public class Typing {

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

//		開始時刻を取得
		long startTime = System.currentTimeMillis();

//		10回繰り返す
		for(int i = 0; i < 10; i++) {
//			タイピングリストを無作為に取得
			Sentence sentence = manager.getRandomSentence();
//			タイピングのための文字列を表示
			System.out.println(sentence.getText() + "(" + sentence.getFirstTyping() + ")");

//			文字列を書式を指定して表示
//			System.out.println(
//					String.format(
//							"%s (%s)",                   %s = 何らかの文字列
//							sentence.getText(),			 一つ目の「%s」に入る
//							sentence.getFirstTyping()    二つ目の「%s」に入る
//							)
//					);

			String line = null;
//			boolean b = true;
			do {

//				入力文字を取得
				line = scanner.nextLine();

				if(sentence.contains(line)) {
					System.out.println("○");
					count++;
				} else {
					System.out.println("×");
				}

//				if(!(sentence.contains(line))) {
//					b = true;;
//				} else {
//					b = false;
//				}
//			間違っていれば再度入力させる
			} while(!(sentence.contains(line)));

		}


		long endTime = System.currentTimeMillis();

		double second = (double)(endTime - startTime) / 1000.0;
		System.out.println(second + "秒かかったよ！");

//		System.out.println(
//				String .format("%.2f秒かかったよ！", second)   f = 小数、%.2f = 小数点第2まで表示
//				);

		System.out.println("正解数：" + count);

	}


}
