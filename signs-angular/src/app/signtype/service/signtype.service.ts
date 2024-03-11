import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {SignTypes} from "../model/signtypes";
import {SignDetails} from "../../sign/model/sign-details";
import {SignForm} from "../../sign/model/sign-form";
import {SignTypeForm} from "../model/signtype-form";
import {SignTypeDetails} from "../model/signtype-details";

@Injectable({
  providedIn: 'root'
})
export class SignTypeService {
  constructor(private http: HttpClient) {

  }

  deleteSignType(uuid: string): Observable<any> {
    return this.http.delete('http://localhost:8082/api/signtypes/' + uuid);
  }

  getSignType(uuid: string): Observable<SignTypeDetails> {
    return this.http.get<SignTypeDetails>('http://localhost:8082/api/signtypes/' + uuid);
  }

  getSignTypes(): Observable<SignTypes> {
    return this.http.get<SignTypes>('http://localhost:8082/api/signtypes');
  }

  putSign(uuid: string, request: SignTypeForm): Observable<any> {
    return this.http.put('http://localhost:8082/api/signtypes/' + uuid, request);
  }

}
