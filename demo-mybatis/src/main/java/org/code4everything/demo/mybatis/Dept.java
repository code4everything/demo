package org.code4everything.demo.mybatis;

/**
 * @author pantao
 * @since 2019/9/30
 */
public class Dept {

    private Integer id;

    private Integer dept;

    private String name;

    private Integer salary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Dept{" + "id=" + id + ", dept=" + dept + ", name='" + name + '\'' + ", salary=" + salary + '}';
    }
}
