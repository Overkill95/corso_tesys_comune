import { Component } from '@angular/core';
import { DepartmentService } from '../services/department.service';

@Component({
  selector: 'app-department',
  standalone: true,
  imports: [],
  templateUrl: './department.component.html',
  styleUrl: './department.component.css'
})
export class DepartmentComponent {
  
  constructor(private departmentService: DepartmentService){}

  departments:any = [];

  ngOnInit(){
    this.loadDepartments();
  }

  loadDepartments(){
  this.departmentService.getDepartments().subscribe((department:any)=>{
    console.log(department);
    this.departments = department;
  })

  }
}
