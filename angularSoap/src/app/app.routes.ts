import { Routes } from '@angular/router';
import { DetailsEmployeeComponent } from './details-employee/details-employee.component';
import { EmployeeComponent } from './employee/employee.component';
import { AppComponent } from './app.component';

export const routes: Routes = [
    {path: 'details/:id',component: DetailsEmployeeComponent },
    {path:'',component:AppComponent},
    {path:'employees',component:EmployeeComponent}
];
