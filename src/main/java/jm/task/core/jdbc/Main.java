package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();
        userList.add(new User("Stavr", "Godinovich", (byte) 34));
        userList.add(new User("Petro", "Smirnov", (byte) 45));
        userList.add(new User("Vasil", "Bukov", (byte) 27));
        userList.add(new User("Kirill", "Doron", (byte) 98));

        // 1. Создание таблицы User(ов)
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();

        // 2. Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль
        // ( User с именем – name добавлен в базу данных )
        for (User unit: userList) {
            userService.saveUser(unit.getName(), unit.getLastName(), unit.getAge());
            System.out.println(String.format("User с именем %s добавлен в базу данных.", unit.getName()));
        }

        // 3. Получение всех User из базы и вывод в консоль
        List<User> usersFromDB = userService.getAllUsers();
        for (User unit: usersFromDB) {
            System.out.println(unit);
        }

        // 4. Очистка таблицы User(ов)
        userService.cleanUsersTable();

        // 5. Удаление таблицы
        userService.dropUsersTable();
    }
}
