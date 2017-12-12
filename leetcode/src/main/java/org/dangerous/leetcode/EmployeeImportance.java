package org.dangerous.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/employee-importance/description/
 * Created by limeng on 17-12-12.
 */
public class EmployeeImportance {

    /**
     * map存储，dfs递归相加,使用java8 lambda表达式,比foreach 慢70ms
     *
     * @param employees
     * @param id
     * @return
     */
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> emps = new HashMap<>(employees.size());
        for (Employee employee : employees) {
            emps.put(employee.id, employee);
        }

        return helper(emps, id);
    }

    int helper(Map<Integer, Employee> emps, int id) {
        Employee emp = emps.get(id);
        int sum = emp.importance;
        if (emp.subordinates.isEmpty()) {
            return sum;
        }
        for (int i = 0; i < emp.subordinates.size(); i++) {
            sum += helper(emps, emp.subordinates.get(i));
        }
        return sum;
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

}
