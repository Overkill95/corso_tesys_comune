import { Component } from '@angular/core';
import { DepartmentService } from '../services/department.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-department',
  standalone: true,
  imports: [RouterModule,CommonModule],
  templateUrl: './department.component.html',
  styleUrl: './department.component.css'
})
export class DepartmentComponent {
  
  constructor(public authService: AuthService,private departmentService: DepartmentService){}

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


  deleteItem(departmentId:number){
    this.departmentService.deleteDepartment(departmentId).subscribe(() =>{
      console.log("dep delete");
    })
  }
}
