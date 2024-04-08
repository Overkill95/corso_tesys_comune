import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { RouterModule } from '@angular/router'

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [ReactiveFormsModule, RouterModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {
  public signupForm: FormGroup;


  constructor(private formbuilder: FormBuilder,private http: HttpClient, private router: Router,private route: ActivatedRoute){
    this.signupForm = this.formbuilder.group({
      username: [''],
      password: ['', Validators.required],
      role: ['']
      // this.formbuilder.array([])
    })
  }

  ngOnInit(): void {
    
  }

  signup(){
    const loginPayload = {
      username: this.signupForm.value.username,
      password: this.signupForm.value.password,
      role: [this.signupForm.value.role]
    };
    this.http.post<any>('/WSEmployeesSoapController' + '/addUser', loginPayload).subscribe(data => {
      console.log('SignUp successful');
      
       
        this.router.navigate(['/login']);
  },
  error => {
      console.error('SignUp failed');
      alert("Qualcosa è andato storto");
  });
  }

}
