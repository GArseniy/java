public class Generator {
	public static void main(String[] args) {
		String[] wordList0 = {"Круглосуточный", "Трех-звенный", "30000-футовый", "Взаимный", "Обоюдный выигрыш",
			"Фронтэнд", "На основе веб-технологий", "Проникающий", "Умный", "Шесть сигм",
		       	"Метод критического пути", "Динамичный"};
		String[] wordList1 = {"уполномоченный", "трудный", "чистый продукт", "ориентированный", "центральный",
			"распределённый", "кластеризированный", "фирменный", "нестандартный ум", "позиционированный",
			"сетевой", "сфокусированный", "исползованный с выгодой", "выровненный", "нацеленный на",
			"общий", "совместный", "ускоренный"};
		String[] wordList2 = {"процесс", "пункт разгрузки", "выход из положения", "тип структуры", "талант",
			"подход", "уровень завоеванного внимания", "портал", "период времени", "обзор", "образец", 
			"пункт следования"};	
		String[][] wordList = {wordList0, wordList1, wordList2};
		
		String phrase = "";
		for (byte i = 0; i < 3; i++) {
			phrase += wordList[i][(int) (Math.random() * wordList[i].length)] + " ";
		}
		System.out.println("Всё, что нам нужно - " + phrase);
	}
}
