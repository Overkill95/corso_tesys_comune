import { HttpHeaders, HttpInterceptorFn } from '@angular/common/http';
import { request } from 'http';

export const sessioninterceptorInterceptor: HttpInterceptorFn = (req, next) => {

  
  let token = sessionStorage.getItem('token');
  

    if (token) {
     req = req.clone({
       setHeaders: {
         Authorization: token
       }
     });
   }

   return next(req);

};
