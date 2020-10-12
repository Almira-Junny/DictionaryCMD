import java.io.*;
import java.util.*;

public class DictionaryManagement extends Dictionary {

    final String dictionary_path = "./resource/dictionaries.txt";
    final String export_path = "./resource/export.txt";

    public void insertFromCommandline() {
        System.out.println("Insert word from command line: ");
        System.out.print("Input number of words in dictionary: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfVocabulary = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfVocabulary; i++) {
            String wordTarget = scanner.nextLine();
            String wordExplain = scanner.nextLine();
            Word newWord = new Word(wordTarget, wordExplain);
            allWords.add(newWord);
        }
        System.out.println("Done!");
    }

    public void insertFromFile() {
        Scanner scanner = Utils.readFile(dictionary_path);
        while (true) {
            assert scanner != null;
            if (!scanner.hasNextLine()) break;
            Word newWord = new Word();
            newWord.readWord(scanner);
            allWords.add(newWord);
        }
        System.out.println("Loaded!");
    }

    public void dictionaryLookup() {
        System.out.println("Write the word you want to lookup: ");
        Scanner scanner = new Scanner(System.in);
        String lookupWord = scanner.nextLine();
        for (Word word: allWords) {
            if (word.wordTarget.equals(lookupWord)) {
                word.writeWord();
                return;
            }
        }
        System.out.println("Can't find word \"" + lookupWord + "\" in dictionary!");
    }

    public void addWordToDictionary() {
        System.out.println("Write the word you want to add: ");
        Word newWord = new Word();
        newWord.readWord(new Scanner(System.in));
        allWords.add(newWord);
        System.out.println("Added!");
    }

    public void removeWordFromDictionary() {
        System.out.println("Write the word you want to remove: ");
        Scanner scanner = new Scanner(System.in);
        String removeWord = scanner.nextLine();
        allWords.removeIf(word -> word.wordTarget.equals(removeWord));
        System.out.println("Removed!");
    }

    public void editWordInDictionary() {
        System.out.println("Write the word you want to edit: ");
        Word editWord = new Word();
        editWord.readWord(new Scanner(System.in));
        for (int i = 0; i < allWords.size(); i++) {
            if (allWords.get(i).wordTarget.equals(editWord.wordTarget)) {
                allWords.set(i, editWord);
            }
        }
        System.out.println("Edited!");
    }

    public void dictionaryExportToFile() {
        PrintWriter printWriter = Utils.writeFile(export_path);
        assert printWriter != null;
        printWriter.printf("%-15s %-20s %-15s%n", "No", "English", "Vietnamese");
        for (int i = 0; i < allWords.size(); i++) {
            printWriter.printf("%-15d %-20s %-15s%n", (i + 1), allWords.get(i).wordTarget, allWords.get(i).wordExplain);
        }
        printWriter.close();
        System.out.println("Exported dictionary to \"" + export_path + "\"");
    }
}