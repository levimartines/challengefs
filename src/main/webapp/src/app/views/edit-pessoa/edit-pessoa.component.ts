import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {pipe} from "rxjs";
import {take} from "rxjs/operators";
import {PessoaService} from "../../services/pessoa.service";
import {Pessoa} from "../../models/pessoa.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Endereco} from "../../models/endereco.model";

@Component({
    selector: 'app-edit-pessoa',
    templateUrl: './edit-pessoa.component.html',
    styleUrls: ['./edit-pessoa.component.css']
})
export class EditPessoaComponent implements OnInit {

    id: number = null;
    pessoa: Pessoa = null;
    enderecos: Endereco[] = [];
    form: FormGroup;
    submitted = false;
    loading = false;

    constructor(
        private activatedRoute: ActivatedRoute,
        private pessoaService: PessoaService,
        private router: Router,
        private formBuilder: FormBuilder) {
        this.form = this.formBuilder.group({
            nome: ['', Validators.required],
            email: ['', [Validators.required, Validators.email]],
        });
    }

    ngOnInit() {
        this.activatedRoute.params.subscribe(param => {
            pipe(take(1));
            if (param.hasOwnProperty('id')) {
                this.id = param['id'];
                this.pessoaService.getById(this.id).subscribe((res: Pessoa) => {
                    this.pessoa = res;
                    this.setFormValues();
                    this.pessoaService.getEnderecosByPessoaId(this.id)
                    .subscribe((res: Endereco[]) => {
                        this.enderecos = res;
                    })
                }, error => console.log(error));
            }
        });
    }

    setFormValues() {
        this.form.get('nome').setValue(this.pessoa.nome);
        this.form.get('email').setValue(this.pessoa.email);
    }

    get f() {
        return this.form.controls;
    }

    save() {
        this.loading = true;
        this.submitted = true;
        if (this.form.invalid) {
            return;
        }
        this.pessoaService.update(this.form.value, this.id).subscribe((res: Pessoa) => {
                alert("Usuário alterado com Sucesso!");
                this.router.navigate(['/']).then();
            },
            error => {
                this.loading = false;
                console.log(error)
            }
        );
    }

}
