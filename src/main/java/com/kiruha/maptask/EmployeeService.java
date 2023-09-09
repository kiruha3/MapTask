package com.kiruha.maptask;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    public final Integer maxCountEmployee = 20;
    public Map<Integer,Employee> employee = new HashMap<>(Map.of(
            6554,new Employee("Ольга", "Васнецова",6554),
            6555, new Employee("Василий", "Синицин",6555),
            6556,new Employee("Инга", "Третьякова",6556),
            6557,new Employee("Виталя", "Носков",6557),
            6558,new Employee("Зина", "Зинаидов",6558),
            6559,new Employee("Уля", "Таккаяко",6559),
            6560,new Employee("Лена", "Кудрявцева",6560),
            6561,new Employee("Ида", "Горшановна",6561),
            6562,new Employee("Аглая", "Осиповна",6562),
            6563,new Employee("Зара", "Мальдер",6563)
    ));
}