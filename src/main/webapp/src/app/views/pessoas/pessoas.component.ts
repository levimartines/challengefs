import {Component, OnInit} from '@angular/core';
import {Pessoa} from "../../models/pessoa.model";
import {PessoaService} from "../../services/pessoa.service";

@Component({
    selector: 'app-pessoas',
    templateUrl: './pessoas.component.html',
    styleUrls: ['./pessoas.component.css']
})
export class PessoasComponent implements OnInit {
    pessoas: Pessoa[];

    constructor(private pessoaService: PessoaService) {
    }

    ngOnInit() {
        this.pessoaService.getPessoas().subscribe((res: Pessoa[]) => {
            this.pessoas = res;
        });
    }

    editar(id: number) {

    }

    excluir(id: number) {
        this.pessoaService.deletePessoa(id).subscribe(() => {
            let index = this.pessoas.findIndex(p => p.id == id);
            if (index > -1) {
                this.pessoas.splice(index, 1);
            }
        })
    }
}
