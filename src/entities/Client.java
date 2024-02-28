package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String name;
    private String email;
    private LocalDate birthDate;

    public Client(String name, String email, String birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = LocalDate.parse(birthDate, fmt);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return fmt.format(birthDate);
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = LocalDate.parse(birthDate, fmt);
    }
}
