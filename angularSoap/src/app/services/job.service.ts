import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';


const BASE_URL='/WSEmployeesSoapController';

@Injectable({
  providedIn: 'root'
})
export class JobService {

  private http = inject(HttpClient)
  constructor() { }

  getJobs(){
    return this.http.get(BASE_URL + "/getJobs");
  }
}
