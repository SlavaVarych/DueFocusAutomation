package Data;

import Page.SignUpPage;

public class TestDataDueFocus {

    public enum LoginUser{

        USER1("testUser","qwerty123"),
        USER2("varich@bughuntress.com", "qwerty123456"),
        //Acc for DueFocus
        USER3("slava.varych11@gmail.com", "Qwe12345"),
        //Acc for Gmail
        USER4("slava.varych11@gmail.com", "!QAZxsw2");

        private String login;
        private String password;

        public String getLogin(){return this.login;}
        public String getPassword(){return this.password;}

        LoginUser(String login, String password){
            this.login = login;
            this.password = password;
        }
    }

    public enum SignUpUser{
        USER1("Slavon", "Varych", "test@test.com", "Qwe12345678");



        private String firstName;
        private String lastName;
        private String email;
        private String password;

        public String getFirstName(){return this.firstName;}
        public String getLastName(){return this.lastName;}
        public String getEmail(){return this.email;}
        public String getPassword(){return this.password;}

        SignUpUser(String firstName, String lastName, String email, String password){
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
        }


    }

}
