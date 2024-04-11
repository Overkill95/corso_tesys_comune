import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const BASE_URL='/WSEmployeesSoapController';
@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  private http = inject(HttpClient)
  constructor() { }

  getDepartments(){
    return this.http.get(BASE_URL + "/getDepartments");
  }
}
