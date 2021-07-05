import { Component } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';
import { UsersService } from 'src/app/services/UsersService';

@Component({
    selector: 'login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent {
    form: FormGroup;
    usersService:UsersService;

    constructor(
        private formBuilder: FormBuilder,
        private router: Router,
    ) { }

    ngOnInit(): void {
        this.form = this.formBuilder.group({
            username: '',
            password: '',
            rememberMe: false
        });
    }

    onSubmit(): void {
            const user: User = {
                username: this.form.value.username,
                password: this.form.value.password
            };
            
            this.usersService.login(user).subscribe((user: User) => {
                
                    this.usersService.connectedUser = user;
                    this.usersService.emitConnectedUser();
            
                this.router.navigate(['loggedin']);
        
            })
    }

}
