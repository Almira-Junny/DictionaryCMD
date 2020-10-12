import java.util.*;

public class DictionaryCommandline extends DictionaryManagement {

    public void showAllWords() {
        System.out.printf("%-15s %-20s %-15s%n", "No", "English", "Vietnamese");
        for (int i = 0; i < allWords.size(); i++) {
            System.out.printf("%-15d %-20s %-15s%n", (i + 1), allWords.get(i).wordTarget, allWords.get(i).wordExplain);
        }
    }

    public void dictionarySearcher() {
        System.out.println("Điền từ bạn cần tìm kiếm: ");
        Scanner scanner = new Scanner(System.in);
        String searchWord = scanner.nextLine();
        for (Word word: allWords) {
            if (word.wordTarget.startsWith(searchWord)) {
                word.writeWord();
            }
        }
    }

    public void showAllCommand() {
        System.out.println("remove :Xóa từ");
        System.out.println("edit   :Chỉnh sửa từ");
        System.out.println("add    :Thêm từ");
        System.out.println("lookup :Tra cứu từ");
        System.out.println("show   :Hiển thị tất cả");
        System.out.println("search :Tìm kiếm từ");
        System.out.println("export :Chuyển dữ liệu sang file export");
        System.out.println("exit   :Kết thúc");
        System.out.println("");
    }

    public void dictionaryBasic() {
        insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() {
        insertFromFile();
        showAllWords();
        showAllCommand();
        boolean isRunning = true;
        while(isRunning) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            switch (command) {
                case "remove":
                    removeWordFromDictionary();
                    break;
                case "edit":
                    editWordInDictionary();
                    break;
                case "add":
                    addWordToDictionary();
                    break;
                case "lookup":
                    dictionaryLookup();
                    break;
                case "show":
                    showAllWords();
                    break;
                case "search":
                    dictionarySearcher();
                    break;
                case "export":
                    dictionaryExportToFile();
                    break;
                case "help":
                    showAllCommand();
                    break;
                case "exit":
                    isRunning = false;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        DictionaryCommandline Dictionary = new DictionaryCommandline();
        Dictionary.dictionaryAdvanced();
    }
}
