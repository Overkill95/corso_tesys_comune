import { Component,OnInit,inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { EmployeeService } from '../services/employee.service';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AuthService } from '../services/auth.service';


@Component({
  selector: 'app-employee',
  standalone: true,
  imports: [RouterModule, CommonModule],
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent implements OnInit {
  
  constructor(public authService: AuthService, private router: Router) { }

  //http = inject(HttpClient)
  private employeeService = inject(EmployeeService)
  employees: any = [];

  ngOnInit(): void {
    // this.fetchEmployees();

    this.loadEmployees();
    

  }

/*   fetchEmployees(){
    this.http.get('http://localhost:9083/RestControllerNew/employees/getAll')
    .subscribe((employees: any)=>{
      console.log(employees);
      this.employees = employees;
    })
  } */

  loadEmployees(){
    this.employeeService.getEmployees().subscribe((employees: any)=>{
      console.log(employees);
      this.employees = employees;
    });
  }


  deleteItem(employeeId:number){
    this.employeeService.deleteEmployee(employeeId).subscribe(
      () => {
        console.log('Employee deleted successfully');
        this.employees = this.employees.filter((employee: { id: number; }) => employee.id !== employeeId);
       
      this.employeeService.getEmployees().subscribe(
        employees => {
          this.employees = employees;
        },
        error => {
          console.error('Error fetching employees:', error);
        }
      );
      },
      error => {
        console.error('Error deleting employee:', error);
      }
    );
  }


}
