package com.stulikov.stream;

import com.stulikov.stream.ClientPhone.Phone.PhoneType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClientPhone {

    static class Client {
        Integer id;
        String name;
        Double age;
        List<Phone> phones;

        public Client(Integer id, String name, Double age, List<Phone> phones) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.phones = phones;
        }

        @Override
        public String toString() {
            return "Client{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", phones=" + phones +
                    '}';
        }

        public String getName() {
            return name;
        }

        public Double getAge() {
            return age;
        }
    }

    static class Phone {
        Long number;
        PhoneType type;

        public Phone(Long number, PhoneType type) {
            this.number = number;
            this.type = type;
        }

        enum PhoneType {
            STATIONARY,
            MOBIL
        }
    }

    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client(1, "Alice", 30.0,
                List.of(new Phone(123L, Phone.PhoneType.MOBIL))));
        clients.add(new Client(2, "Bob", 45.0,
                List.of(new Phone(456L, Phone.PhoneType.STATIONARY))));
        clients.add(new Client(3, "Charlie", 40.0,
                List.of(new Phone(789L, Phone.PhoneType.STATIONARY), new Phone(321L, Phone.PhoneType.MOBIL))));


        Client client = clients.stream().filter(c -> c.phones.stream().anyMatch(p -> p.type == PhoneType.STATIONARY)).
                max(Comparator.comparingDouble(Client::getAge)).get();

        System.out.println(client);
    }
}
