package com.stulikov.atm;

import java.util.*;
import java.util.stream.Collectors;

public class ATM {  // Хранение купюр: номинал -> количество

    private final Map<Integer, Integer> banknotes = new TreeMap<>(Comparator.reverseOrder()); // по убыванию

    // Синхронизированное пополнение
    public synchronized void deposit(int denomination, int count) {
        if (denomination <= 0 || count <= 0) throw new IllegalArgumentException("Invalid deposit");
        banknotes.merge(denomination, count, Integer::sum);
    }

    // Выдача с учетом предпочтительных номиналов
    public synchronized Optional<Map<Integer, Integer>> withdraw(int amount, List<Integer> preferredDenominations) {
        if (amount <= 0) return Optional.empty();

        // Используем только те номиналы, которые есть и в банкомате, и в предпочтениях
        Set<Integer> allowed = new HashSet<>(preferredDenominations);
        Map<Integer, Integer> available = banknotes.entrySet().stream()
                                                   .filter(e -> allowed.contains(e.getKey()))
                                                   .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                                           (a, b) -> b, LinkedHashMap::new));

        Map<Integer, Integer> result = new LinkedHashMap<>();
        int remaining = amount;

        for (Map.Entry<Integer, Integer> entry : available.entrySet()) {
            int denom = entry.getKey();
            int availableCount = entry.getValue();
            int needed = remaining / denom;
            if (needed > 0) {
                int take = Math.min(needed, availableCount);
                result.put(denom, take);
                remaining -= take * denom;
            }
        }

        if (remaining == 0) {
            // Успешно: обновляем банкомат
            result.forEach((k, v) -> banknotes.merge(k, -v, Integer::sum));
            return Optional.of(result);
        }

        return Optional.empty(); // невозможно выдать сумму
    }

    // Простая выдача без предпочтений
    public Optional<Map<Integer, Integer>> withdraw(int amount) {
        return withdraw(amount, new ArrayList<>(banknotes.keySet()));
    }

    public synchronized Map<Integer, Integer> getBalance() {
        return new TreeMap<>(banknotes);
    }

    // Пример использования
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.deposit(1000, 5);
        atm.deposit(500, 5);
        atm.deposit(100, 10);
        atm.deposit(50, 10);

        System.out.println("Выдача без предпочтений: " + atm.withdraw(1850));
        System.out.println("С предпочтением 100 и 50: " + atm.withdraw(150, List.of(100, 50))); // 1x100, 1x50
        System.out.println("Баланс: " + atm.getBalance());
    }
}
