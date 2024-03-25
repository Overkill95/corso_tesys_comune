import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Employee } from '../employee';

const BASE_URL='http://localhost:9083/WSEmployeesSoapController';
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
    return this.http.get<Employee>(BASE_URL + `/getEmployee/${id}`);
  }


}
