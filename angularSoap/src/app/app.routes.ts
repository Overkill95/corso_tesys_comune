import { Routes } from '@angular/router';
import { DetailsEmployeeComponent } from './details-employee/details-employee.component';
import { EmployeeComponent } from './employee/employee.component';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { ErrorComponent } from './error/error.component';
import { SignupComponent } from './signup/signup.component';

export const routes: Routes = [
    {path: 'details/:id',component: DetailsEmployeeComponent },
    {path:'',component:LoginComponent},
    {path:'employees',component:EmployeeComponent},
    {path:'login',component:LoginComponent},
    {path:'error',component:ErrorComponent},
    {path:'signup',component:SignupComponent}

];
