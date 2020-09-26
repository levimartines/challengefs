import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable()
export class PessoaService {
    private BASE_URL = environment.apiUrl;

    constructor(private http: HttpClient) {
    }

    getAll() {
        return this.http.get(this.BASE_URL + '/api/pessoas');
    }

    getById(id: number) {
        return this.http.get(this.BASE_URL + '/api/pessoas/' + id);
    }

    save(obj: any) {
        return this.http.post(this.BASE_URL + '/api/pessoas', obj);
    }

    delete(id) {
        return this.http.delete(this.BASE_URL + '/api/pessoas/' + id);
    }

    update(obj: any, id: number) {
        return this.http.put(this.BASE_URL + '/api/pessoas/' + id, obj);
    }

    getEnderecosByPessoaId(id: number) {
        return this.http.get(this.BASE_URL + '/api/pessoas/' + id + '/enderecos');
    }

}
