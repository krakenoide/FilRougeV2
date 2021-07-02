/* General modules */
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

/* Router */
import { RouterModule } from '@angular/router';
import { routes } from './routes';

/* Components */
import { AppComponent } from './app.component';
import { UnloggedpageComponent } from './components/unloggedpage/unloggedpage.component';
import { LoginComponent } from './components/login/login.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { LogoutComponent } from './components/logout/logout.component';
import { LoggedinpageComponent } from './components/loggedinpage/loggedinpage.component';

/* Dialogs */
import { DialogConfirmComponent } from './dialogs/dialog-confirm.component';

/* Pipes */

/* Services */
import { UsersService } from './services/UsersService';

/* Angular Material */
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatButtonModule } from '@angular/material/button';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatDialogModule } from '@angular/material/dialog';

@NgModule({
    declarations: [
        AppComponent,
        UnloggedpageComponent,
        LoginComponent,
        SignInComponent,
        LogoutComponent,
        LoggedinpageComponent,
        DialogConfirmComponent
    ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        RouterModule.forRoot(routes),
        HttpClientModule,
        ReactiveFormsModule,
        MatFormFieldModule,
        MatInputModule,
        MatCheckboxModule,
        MatButtonModule,
        MatSnackBarModule,
        MatDialogModule
    ],
    providers: [
        UsersService
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
