import { Component, inject } from '@angular/core';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { RouterModule } from '@angular/router'
import { EmployeeService } from '../services/employee.service';
import { JobService } from '../services/job.service';
import { UserDto } from '../user-dto';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [ReactiveFormsModule, RouterModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {
  public signupForm: FormGroup;
  jobs:any = [];
  managerId:any = ['100','101','102','103','108','114','123','201'];
  roles: string[] = ['ADMIN', 'USER'];

  constructor(private formbuilder: FormBuilder,private http: HttpClient, private router: Router,private route: ActivatedRoute, private employeeService: EmployeeService, private jobService: JobService){
    this.signupForm = this.formbuilder.group({
      username: [''],
      password: ['', Validators.required],
      role: [null, Validators.required],
      jobId : [],
      firstName : [''],
      lastName : [''],
      email : [''],
      phoneNumber : [''],
      hireDate : [''],
      salary : [],
      managerId : [],
      departmentId : []
      // this.formbuilder.array([])
    })

   
  }

  ngOnInit(): void {
    this.loadJobs();
  }

  signup(){
    
    this.addEmployee();
    
  
  }

  addEmployee(){

    const userDto: UserDto = {
      username: this.signupForm.value.username,
      password: this.signupForm.value.password,
      role: [this.signupForm.value.role]
    };


    const employee = {
      firstName: this.signupForm.value.firstName,
      lastName: this.signupForm.value.lastName,
      email: this.signupForm.value.email,
      phoneNumber: this.signupForm.value.phoneNumber,
      hireDate: this.signupForm.value.hireDate,
      jobId: this.signupForm.value.jobId,
      salary: this.signupForm.value.salary,
      managerId: this.signupForm.value.managerId,
      departmentId: this.signupForm.value.departmentId,
      user: userDto
      // user: {
      //   username: this.signupForm.value.username,
        
      // }
  
    };
    this.http.post<any>('/WSEmployeesSoapController' + '/addEmployee', employee).subscribe(data => {
      // this.employeeService.addEmployee(employee).subscribe(data =>{
          console.log("utente registrato")
      },
      error =>{
        console.error('utente non inserito');
        alert("Qualcosa è andato storto");
      });
  }

  loadJobs(){
    this.jobService.getJobs().subscribe((job: any)=>{
      console.log(job);
      this.jobs = job;
    });
  }


}
