import { Component, OnInit } from '@angular/core';
import { Observable, Subscription} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import { User } from 'src/app/models/User';
import { UsersService } from 'src/app/services/UsersService';
import { Router } from '@angular/router';
import { Morceau } from 'src/app/models/Morceau';
import { Artiste } from 'src/app/models/Artiste';
import { Album } from 'src/app/models/Album';
import { FormControl } from '@angular/forms';

@Component({
    selector: 'loggedinpage',
    templateUrl: './loggedinpage.component.html',
    styleUrls: ['./loggedinpage.component.css']
})
export class LoggedinpageComponent implements OnInit{
    listeMorceaux:Morceau[]=[];
    listeArtistes:Artiste[]=[];
    listeAlbums:Album[]=[];
    
    myControl = new FormControl();
    options: string[] = ['One', 'Two', 'Three'];
    filteredOptions: Observable<string[]>;

    constructor(
        private router: Router
    ) { }

    ngOnInit() {
        this.filteredOptions = this.myControl.valueChanges
          .pipe(
            startWith(''),
            map(value => this._filter(value))
          );
      }
    
      private _filter(value: string): string[] {
        const filterValue = value.toLowerCase();
    
        return this.options.filter(option => option.toLowerCase().includes(filterValue));
      }

}
