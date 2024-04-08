import { Injectable, inject } from '@angular/core';
import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptorFn, HttpRequest } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { Router } from '@angular/router';


export const errorInterceptorInterceptor: HttpInterceptorFn = (req, next) => {
  const router = inject(Router);
  return next(req).pipe(
    
    catchError((err: any) => {
      if (err instanceof HttpErrorResponse) {
        
        if (err.status === 403 ) {
                  
          console.error('Unauthorized request:', err);
          router.navigate(['/error']);

          
        } 
        // else {
        //   // Handle other HTTP error codes
        //   console.error('HTTP error:', err);
        // }
      } 

      return throwError(() => err); 
    })
  )
};




