import { Injectable, Inject, PLATFORM_ID  } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  
  private currentUserSubject: BehaviorSubject<any>;
  public currentUser: Observable<any>;

  constructor(private http: HttpClient, @Inject(PLATFORM_ID) private platformId: Object) {
    let user;
    if (isPlatformBrowser(this.platformId)) {
      
      user = JSON.parse(localStorage.getItem('currentUser') || 'null');
    } else {
     
      user = null;
    }

    
    

    this.currentUserSubject = new BehaviorSubject<any>(user);

    this.currentUser = this.currentUserSubject.asObservable();

    
  }

  public get isLoggedIn$(): Observable<boolean> {
    return this.currentUser.pipe(map(user => !!user));
    }

  
    public get isAuthorized$(): Observable<boolean> {
      return this.currentUser.pipe(
        map(user => user && Array.isArray(user.role) && user.role.includes('ROLE_ADMIN'))
      );
    }
    
  

  public get currentUserValue() {
    return this.currentUserSubject.value;
  }

  login(username: string, password: string) {
    return this.http.post<any>('/WSEmployeesSoapController' + '/login', { username, password })
        .pipe(map(user => {
           localStorage.setItem('currentUser', JSON.stringify(user));
            this.currentUserSubject.next(user);
            return user;
        })); 
  }

  logout() {

    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }

  
}
