import { Component, OnDestroy, OnInit } from '@angular/core';
import { User } from './models/User';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
    connectedUser: User;
    navigation:any;

    ngOnInit(): void {
        this.navigation=document.querySelector("ul");

        window.addEventListener("scroll", () => {
	    if (window.scrollY>70){
		    this.navigation.classList.add("nav-links-animation");
	    } else {
		    this.navigation.classList.remove("nav-links-animation");
	    }
        });
    }

}
