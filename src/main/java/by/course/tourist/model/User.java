package by.course.tourist.model;

public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private int roleId;
    private String login;
    private int password;

    public User() {
    }

    public User(String name, String surname, String email, int roleId, String login, int password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.roleId = roleId;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " " + email + " " + login;
    }
}
