package org.example.entities.user;

public class Company {
    private String name;
    private String catchPhrase;
    private String bs;

    public Company(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    @Override
    public String toString() {
        return  "\n     \"name\": " + name +
                "\n     \"catchPhrase\": " + catchPhrase +
                "\n     \"bs\": " + bs +
                "\n   }";
    }
}
