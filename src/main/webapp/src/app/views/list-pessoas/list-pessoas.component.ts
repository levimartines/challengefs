import {Component, OnInit} from '@angular/core';
import {Pessoa} from "../../models/pessoa.model";
import {PessoaService} from "../../services/pessoa.service";

@Component({
    selector: 'app-list-pessoas',
    templateUrl: './list-pessoas.component.html',
    styleUrls: ['./list-pessoas.component.css']
})
export class ListPessoasComponent implements OnInit {
    pessoas: Pessoa[];

    constructor(private pessoaService: PessoaService) {
    }

    ngOnInit() {
        this.pessoaService.getAll().subscribe((res: Pessoa[]) => {
            this.pessoas = res;
        });
    }

    editar(id: number) {
        console.log(id);
    }

    excluir(id: number) {
        this.pessoaService.delete(id).subscribe(() => {
            let index = this.pessoas.findIndex(p => p.id == id);
            if (index > -1) {
                this.pessoas.splice(index, 1);
            }
        })
    }
}
