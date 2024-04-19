import { HttpInterceptorFn } from '@angular/common/http';


export const sessioninterceptorInterceptor: HttpInterceptorFn = (req, next) => {

  
  // const token2:any = inject(BrowserStorageService);

  //let tokon = token2.get('token');
  
  let token;
  
  if (typeof sessionStorage !== 'undefined') {
    token = sessionStorage.getItem('token');
  }

  

    if (token) {
     req = req.clone({
       setHeaders: {
         Authorization: token
       }
     });
   }

   return next(req);

};
