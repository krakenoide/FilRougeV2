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
export class UnloggedpageComponent {
    connectedUser: User;
}