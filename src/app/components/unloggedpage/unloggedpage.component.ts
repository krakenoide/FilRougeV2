import { Component, OnInit } from '@angular/core';
import { Subscription} from 'rxjs';
import { User } from 'src/app/models/User';
import { UsersService } from 'src/app/services/UsersService';
import { Router } from '@angular/router';

@Component({
    selector: 'unloggedpage',
    templateUrl: './unloggedpage.component.html',
    styleUrls: ['./unloggedpage.component.css']
})
export class UnloggedpageComponent implements OnInit {
    connectedUser: User;
    connectedUserSubscription: Subscription;

    constructor(
        private usersService: UsersService,
        private router: Router
    ) { }

    ngOnInit(): void {

        this.usersService.connectedUserSubject.subscribe((user: User) => {
            this.connectedUser = user;
        });

        this.usersService.emitConnectedUser();

    }
}