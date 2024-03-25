import { Component, Input, inject } from '@angular/core';
import { RouterModule } from '@angular/router';
import { EmployeeService } from '../services/employee.service';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../employee';

@Component({
  selector: 'app-details-employee',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './details-employee.component.html',
  styleUrl: './details-employee.component.css'
})
export class DetailsEmployeeComponent {
 
  private employeeService = inject(EmployeeService);
   
  @Input() employee: Employee = {} as Employee;
  employeeId: any;
  arrEmployee:Array<Employee> = []

  constructor(private route: ActivatedRoute) { }

  

  ngOnInit(): void {
    
   /*  this.route.paramMap.subscribe(params => {
      this.employeeId = params.get('id');
      console.log('ID del dipendente:', this.employeeId);

      
    }); */

    this.loadEmployee();
  }

  


  loadEmployee(): void {
    this.route.paramMap.subscribe(params => {
      this.employeeId = params.get('id');
      this.employeeService.getEmployeeById(this.employeeId).subscribe(
        (data) => {
          
          console.log(data);
          this.arrEmployee.push(data) 
          console.log(this.arrEmployee)
        },
        (error: any) => {
          console.error('Errore durante il recupero dei dettagli del dipendente:', error);
        }
      );
    });
  }



}


