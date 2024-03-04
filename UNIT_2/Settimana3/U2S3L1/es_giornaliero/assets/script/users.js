class User {
    constructor(_firstName, _lastName, _age, _location) {
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.age = _age;
        this.location = _location
    }

    compareAge(userX) {
        if (this.age > userX.age) {
            console.log(`${this.firstName} è più vecchio di ${userX.firstName}`);
        }
        else if (userX.age > this.age) {
            console.log(`${userX.firstName} è più vecchio di ${this.firstName}`);
        }
        else {
            console.log(`${this.firstName} e ${userX.firstName} hanno la stessa età`);
        }
    }
}

const user1 = new User('Gabriele', 'Scognamiglio', 29, 'Fiumicino');
const user2 = new User('Gilberto', 'Pasfadini', 55, 'Ostia');
const user3 = new User('Ermenegildo', 'Zanzelli', 18, 'Acilia');

user1.compareAge(user2);
user1.compareAge(user3);