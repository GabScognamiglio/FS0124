class User {
    constructor(_firstName, _lastName, _age, _location) {
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.age = _age;
        this.location = _location
    }

    confrontaAge(x,y) {
        if (x.age>y.age) {
            console.log(`${x.firstName} è più vecchio di ${y.firstName}`)
        }
        else {
            console.log(`${y.firstName} è più vecchio di ${x.firstName}`)
        }
    }
}

const user1 = new User('Gabriele', 'Scognamiglio', 29, 'Fiumicino');
const user2 = new User('Gilberto', 'Pasfadini', 55, 'Ostia');
const user3 = new User('Ermenegildo', 'Zanzelli', 18, 'Acilia');

user1.confrontaAge(user1, user2);
user1.confrontaAge(user1, user3);