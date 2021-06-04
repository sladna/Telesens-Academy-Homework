package com.annasladkykh.lesson7.homework;

import com.annasladkykh.lesson4.Gender;
import com.annasladkykh.lesson4.Person;

import java.util.Random;

public class PersonGenerate {
    public static void main(String[] args) {
        Gender[] genders = {Gender.MALE,Gender.FEMALE}; // [0, 1]
        String[] manFirstNames = {"Архип","Болеслав","Марат","Семён",
                "Юлиан","Сергей","Нифонт","Максим","Евгений","Геннадий",
                "Володар","Ждан","Марк","Григорий","Леонид","Олег"};

        String[] womanFirstNames = {"Виктория","Дария","Арина","Зоя","Лиза","Мария","Надя","Раиса","Тамара",
                "Октябрина","Рая","Роза","Нелли","Милана","Любовь","Леся",
                "Каролина","Зинаида","Карина","Клавдия"};

        String[] manLastNames = {"Смирнов","Иванов","Кузнецов","Попов","Соколов","Лебедев","Козлов","Новиков",
                "Морозов","Петров","Волков","Соловьёв","Васильев","Зайцев","Павлов"};

        String[] womanLastNames = {"Ковалёва","Ильина","Гусева","Титова","Кузьмина","Кудрявцева","Баранова",
                "Куликова","Алексеева","Степанова","Яковалева","Сорокина","Сергеева","Романова","Захарова","Борисова"};

        Random random = new Random();

        Person[] persons = new Person[20]; // [null,null,null,...] =>[Person1, Person2,...]
        for(int i = 0; i < persons.length; i++) {
            int ageFrom = 4;
            int ageTo = 90;
            int ageRandom = ageFrom + random.nextInt(ageTo-ageFrom+1); // 4 + [0..87]
            Gender gender = genders[random.nextInt(2)];
            String name;
            String lastName;

            if (gender == Gender.MALE) {
                name = manFirstNames[random.nextInt(manFirstNames.length)]; // [0, ..., manFirstNames.length-1]
                lastName = manLastNames[random.nextInt(manLastNames.length)];
            } else {
                name = womanFirstNames[random.nextInt(womanFirstNames.length)];
                lastName = womanLastNames[random.nextInt(womanLastNames.length)];
            }

            persons[i] = new Person();
            persons[i].setFirstName(name);
            persons[i].setLastName(lastName); // доделать
            persons[i].setAge(ageRandom);
            persons[i].setGender(Gender.FEMALE);
        }

        for(int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
            assert persons[i].getAge() >= 4 && persons[i].getAge() <=90;
        }

        System.out.println("**********");
        for(Person element : persons) {
            // element => persons[i]
            System.out.println(element);
        }

    }

    public static int nextInt(int from, int to) {
        return from + new Random().nextInt(from-to+1);
    }
}
