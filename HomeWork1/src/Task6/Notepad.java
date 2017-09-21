package Task6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Разработать классы Запись в блокноте и Блокнот (записи блокнота хранятся в массиве).
 * Реализовать методы: Добавить запись, Удалить запись, Редактировать запись, Посмотреть все записи
 * Мне показался удобнее вариант с реализацией интерфейса Операции_Блокнота, нежели создание нового класса
 */


public class Notepad implements NotepadOperations {



    /**
     * Поле для указания размера блокнота
     */

    private int size;


    /**
     * Номер текущей записи
     */

    private int cur;


    /**
     * Блокнот и записями фиксированного размера
     */

    private String[] notes;

    /**
     * Создает новый объект-блокнот с фиксированной длинной (записями фикс.размера)
     *
     * @param size Размер блокнота
     */

    public Notepad(int size) {
        this.size = size;
        notes = new String[size];
    }


    /**
     * Метод вызывается при добавлении в блокнот новой записи
     *
     * @param message Новая запись
     */

    @Override
    public void addNote(String message) {
        if (cur >= size) {
            System.out.println("Sorry, no more space :(");
        } else {
            notes[cur++] = message;
        }
    }


    /**
     * Метод вызывается при удалении записи из блокнота
     *
     * @param message Запись которую необходимо удалить
     */

    @Override
    public void dellNote(String message) {
        List<String> list = new ArrayList<>(Arrays.asList(notes));
        if (!list.contains(message)) {
            System.out.println("Sorry, we dont have it!");
        } else {
            list.removeAll(Arrays.asList(message));
            notes = list.toArray(notes);
        }

    }

    /**
     * Метод вызывается при редактировании блокнота, а именно какой-либо записи
     *
     * @param edmessage Запись которую необходимо отредактировать
     * @param NewMessage Новая запись
     */

    @Override
    public void editNote(String edmessage, String NewMessage) {
        for (int i =0; i<cur; i++) {
            if (notes[i].equals(edmessage)) {
                notes[i] = NewMessage;
                return;
            }
        }
        System.out.println("We havent found "  + edmessage + " note!");
    }


    /**
     * Метод для показа всех записей, содержащихся в блокноте
     *
     */

    @Override
    public void showAllNotes() {
        System.out.println("All notes: ");
        for (String note : notes) {
            if (note == null) {
                break;
            }
            System.out.println(note);
        }
    }
}
