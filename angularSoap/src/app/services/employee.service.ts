import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Employee } from '../employee';

const BASE_URL='/WSEmployeesSoapController';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
private http = inject(HttpClient)
  constructor() { }
  
  getEmployees(){
    return this.http.get(BASE_URL + "/getEmployees");
  }

  deleteEmployee(id:number){
    return this.http.delete(BASE_URL + `/deleteEmployee/${id}`);
  }

  getEmployeeById(id:any){
    return this.http.get<Employee>(BASE_URL + `/getEmployee?id=${id}`);
  }

  addEmployee(user:any){
    return this.http.post<Employee>(BASE_URL + "/addEmployee", {user});
  }


  getEmployeeByUsername(username:any){
    return this.http.get<Employee>(BASE_URL + `/getEmployeeByUsername?username=${username}`);
  }

  getEmployeeByDepartment(depId:any){
    return this.http.get<Employee>(BASE_URL + `/getEmployeeByDepartment?id=${depId}`);
  }


}
