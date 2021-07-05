import { Component, OnInit } from '@angular/core';
import { Subscription} from 'rxjs';
import { User } from 'src/app/models/User';
import { UsersService } from 'src/app/services/UsersService';
import { Router } from '@angular/router';
import { Morceau } from 'src/app/models/Morceau';
import { Artiste } from 'src/app/models/Artiste';
import { Album } from 'src/app/models/Album';

@Component({
    selector: 'loggedinpage',
    templateUrl: './loggedinpage.component.html',
    styleUrls: ['./loggedinpage.component.css']
})
export class LoggedinpageComponent {
    connectedUser: User={id:1,username:"admin",password:"admin"};
    connectedUserSubscription: Subscription;
    listeMorceaux:Morceau[]=[];
    listeArtistes:Artiste[]=[];
    listeAlbums:Album[]=[];

    constructor(
        private usersService: UsersService,
        private router: Router
    ) { }

}
