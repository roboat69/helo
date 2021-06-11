public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(10000, new Person[] { new Person(), new Person() })
    }
    // Bank, person, checking, credit
}

class Bank {
    Person[] users;
    double moneys;

    Bank(double moneys, Person... users) {
        this.users = users;
        this.moneys = moneys;
    }

    void bankLoop() {
        while() {
            boolean cont = true;
            for(int i = 0; i < users.length; i++) {
                if(users[i].alive) {
                    cont = true;
                    break;
                }
            }
            if(!cont) {
            System.exit(0);
            } else {
                monthly();
            }

        }
    }

    void monthly() {
        for (Person person : users) {
            person.age++;
            collectDebit(person);
            checkDebt(person);
            overdraftInterest(person);
        }
    }

    void collectDebit(Person person) {
        for (CheckingAccount account : person.checkingAccount) {
            this.moneys += account.balance * account.interest;
            account.balance -= account.balance * account.interest;
        }
    }

    void collectDebt(Person person) {
        if (person.creditAccount.debt == 0) {

        } else {
            person.creditAccount.overdraft += person.creditAccount.debt;
            person.creditAccount.debt = 0;
        }
    }

    void overdraftInterest(Person person) {
        person.creditAccount.overdraft *= (1 + person.creditAccount.interest);
    }
}

class Person {
    double age;
    boolean alive;
    CheckingAccount[] checkingAccounts;
    CreditAccount creditAccount;
    Person(CheckingAccount[] checkingAccounts, ) {
        age = (Math.random() * 2 + 18) * 12;
        alive = true;

    }
}

class CheckingAccount {
    double balance;
    double minimum;
    double interest;
}

class CreditAccount {
    double creditScore;
    double debt;
    double overdraft;
    double interest;
}