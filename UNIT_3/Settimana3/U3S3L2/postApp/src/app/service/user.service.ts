import { Injectable } from '@angular/core';
import { User } from '../models/user.interface';

@Injectable({
    providedIn: 'root',
})
export class UserService {
    users: User[] = [
        {
            id: 1,
            name: 'Gabriele',
            email: 'gabri@ele.com',
            role: 'admin',
        },
        {
            id: 2,
            name: 'Antonio',
            email: 'anto@nio.it',
            role: 'user',
        },
        {
            id: 3,
            name: 'Clarissa',
            email: 'clar!@issa.org',
            role: 'admin',
        },
        {
            id: 4,
            name: 'Stefano',
            email: 'ste@fano.com',
            role: 'user',
        },
    ];

    constructor() {}

    getUsers() {
        return this.users;
    }

    getUser(id: number) {
        return this.users.find(user => user.id === id);
    }
}
