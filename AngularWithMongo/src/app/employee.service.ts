import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = 'http://localhost:8080/server/api/employees';
  private mongobaseUrl = 'http://localhost:8080/server/api/v2/employees';

  constructor(private http: HttpClient) { }

   getEmployee(id: number): Observable<any> {
     return this.http.get(`${this.baseUrl}/${id}`);
   }

   getEmployeeMongo(id: number): Observable<any> {
    return this.http.get(`${this.mongobaseUrl}/${id}`);
  }

  createEmployee(employee: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, employee);
  }

  createEmployeeMongo(employee: Object): Observable<Object> {
    return this.http.post(`${this.mongobaseUrl}`, employee);
  }

   updateEmployee(id: number, value: any): Observable<Object> {
     return this.http.put(`${this.baseUrl}/${id}`, value);
   }

   deleteEmployee(id: number): Observable<any> {
     return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
   }

   deleteEmployeeMongo(id: number): Observable<any> {
    return this.http.delete(`${this.mongobaseUrl}/${id}`, { responseType: 'text' });
  }

  getEmployeesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
  getEmployeesListMongo(): Observable<any> {
    return this.http.get(`${this.mongobaseUrl}`);
  }
}