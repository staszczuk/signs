import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Signs} from "../model/signs";
import {SignDetails} from "../model/sign-details";
import {SignForm} from "../model/sign-form";

@Injectable()
export class SignService {
  constructor(private http: HttpClient) {

  }

  getSigns(): Observable<Signs> {
    return this.http.get<Signs>('http://localhost:8082/api/signs');
  }

  getSignsBySignType(uuid: string): Observable<Signs> {
    return this.http.get<Signs>('http://localhost:8082/api/signtypes/' + uuid + "/signs");
  }

  getSign(uuid: string): Observable<SignDetails> {
    return this.http.get<SignDetails>('http://localhost:8082/api/signs/' + uuid);
  }

  deleteSign(uuid: string): Observable<any> {
    return this.http.delete('http://localhost:8082/api/signs/' + uuid);
  }

  putSign(uuid: string, request: SignForm): Observable<any> {
    return this.http.put('http://localhost:8082/api/signs/' + uuid, request);
  }

}
