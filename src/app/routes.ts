import { Routes } from '@angular/router';
import { UnloggedpageComponent } from './components/unloggedpage/unloggedpage.component';
import { LoginComponent } from './components/login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { LoggedinpageComponent } from './components/loggedinpage/loggedinpage.component';

export const routes: Routes = [
    { path: '', component: UnloggedpageComponent },
    { path: 'sign-in', component: SignInComponent },
    { path: 'login', component: LoginComponent },
    { path: 'logout', component: LogoutComponent },
    { path: 'loggedin', component: LoggedinpageComponent }
];