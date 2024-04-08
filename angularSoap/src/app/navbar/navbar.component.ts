import { Component } from '@angular/core';
import { RouterModule,  Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterModule, CommonModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  constructor(public authService: AuthService, private router: Router) { }
  
  logout(){
    this.authService.logout();
    this.router.navigate(['/login'])
}
}


