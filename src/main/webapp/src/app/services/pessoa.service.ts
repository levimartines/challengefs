import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable()
export class PessoaService {
    private BASE_URL = environment.apiUrl;

    constructor(private http: HttpClient) {
    }

    getPessoas() {
        return this.http.get(this.BASE_URL + '/api/pessoas');
    }

    deletePessoa(id) {
        return this.http.delete(this.BASE_URL + '/api/pessoas/' + id);
    }

}
