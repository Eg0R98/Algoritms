package com.stulikov.reflection;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) throws Throwable {
        //Считываем данные из файла
        byte[] bytes = Files.readAllBytes(Paths.get("C:\\Users\\Egor\\IdeaProjects\\differents\\src\\main\\resources\\example.txt"));

        //Преобразуем текст из файла в символьную строку
        String contents = new String(bytes, StandardCharsets.UTF_8);

        //Выделяем из всего файла - список слов
        String[] words = contents.split("\\PL+");

        long count = Arrays.stream(words).filter(w -> w.length() > 8).count();
            Arrays.stream(words).parallel().filter(w -> w.length() > 8).count();
    }
}
