package day_4.task2Reflection;

public class newClass {
    private String field1;
    private Integer field2;
    private Integer field3;

    public newClass(String field1, Integer field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public newClass() {
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public Integer getField2() {
        return field2;
    }

    public void setField2(Integer field2) {
        this.field2 = field2;
    }

    public Integer getField3() {
        return field3;
    }

    public void setField3(Integer field3) {
        this.field3 = field3;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "1='" + field1 + '\'' +
                ", 2=" + field2 +
                ", 3=" + field3 +
                '}';
    }
}