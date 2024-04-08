import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { RouterModule } from '@angular/router'

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule, RouterModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  public loginForm: FormGroup;
  username: any;
  password: any;
  sessionId: string = '';
  role:string = '';
  

  constructor(private formbuilder: FormBuilder,private http: HttpClient, private router: Router,private route: ActivatedRoute) {
    this.loginForm = this.formbuilder.group({
      username: [''],
      password: ['', Validators.required]
    })
   }

  ngOnInit(): void {
    
  }
  login(){

    const loginPayload = {
      username: this.loginForm.value.username,
      password: this.loginForm.value.password,
    };
    this.http.post<any>('/WSEmployeesSoapController' + '/login', loginPayload).subscribe(data => {
      console.log('Login successful');
      // Reindirizza l'utente o fai altro 
        this.username = data.username;
        this.sessionId = data.sessionId;
        this.role = data.role
        console.log(this.role)
        console.log(this.username);
        sessionStorage.setItem('token', this.sessionId);
        sessionStorage.setItem('role', this.role);
        this.router.navigate(['/employees']);
  },
  error => {
      console.error('Login failed');
      alert("Credenziali errate");
  });

    /* this.http.post<any>()
    .subscribe(res=>{
      const user = res.find((a:any)=>{
        return a.username === this.loginForm.value.username && a.password === this.loginForm.value.password 
      });
      if(user){
        alert('Login Succesful');
        this.loginForm.reset()
      this.router.navigate(["home"])
      }else{
        alert("user not found")
      }
    },err=>{
      alert("Something went wrong")
    }) */
  }

}
