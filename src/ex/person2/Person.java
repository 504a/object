package ex.person2;

import sample.enumsample.Gender;

class Person {
    private String name;
    private Birthplace birthplace;
    private Gender gender;
    private int age;

    public Person(String name, Birthplace birthplace, Gender gender, int age) {
        this.name = name;
        this.birthplace = birthplace;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Birthplace getBirthplace() {
        return birthplace;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d",
                name,birthplace.getName(),gender.getJpName(),age);
    }
}
