package com.stulikov.stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMap {
    static class Client {
        String name;
        List<Order> orders;

        public Client(String name, List<Order> orders) {
            this.name = name;
            this.orders = orders;
        }

        public String getName() {
            return name;
        }

        public List<Order> getOrders() {
            return orders;
        }

        @Override
        public String toString() {
            return "Client{" +
                    "name='" + name + '\'' +
                    ", orders=" + orders +
                    '}';
        }
    }

    static class Order {
        String product;
        int quantity;

        public Order(String product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public String getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "product='" + product + '\'' +
                    ", quantity=" + quantity +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Client> clients = List.of(
                new Client("Alice", List.of(
                        new Order("Laptop", 1),
                        new Order("Mouse", 2),
                        new Order("Keyboard", 1)
                )),
                new Client("Bob", List.of(
                        new Order("Monitor", 2),
                        new Order("Mouse", 1)
                )),
                new Client("Charlie", List.of(
                        new Order("Laptop", 3),
                        new Order("Headphones", 1)
                )),
                new Client("Diana", List.of(
                        new Order("Mouse", 4),
                        new Order("Laptop", 1),
                        new Order("Laptop", 1)
                ))
        );

        // Найти все уникальные продукты, заказанные всеми клиентами
        Set<String> unicProducts = clients.stream().flatMap(client -> client.getOrders().stream())
                                          .map(Order::getProduct)
                                          .collect(Collectors.toSet());
//        System.out.println(unicProducts);
//
//        // Найти имя клиента, который заказал больше всего разных товаров
//        Map<String, Set<Client>> collect = clients.stream().collect(
//                Collectors.groupingBy(client -> client.getName(), Collectors.toSet())).entrySet().stream();
//        System.out.println(collect);
    }
}
