import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {PessoaService} from "../../services/pessoa.service";
import {Pessoa} from "../../models/pessoa.model";
import {Router} from "@angular/router";

@Component({
    selector: 'app-add-pessoa',
    templateUrl: './add-pessoa.component.html',
    styleUrls: ['./add-pessoa.component.css']
})
export class AddPessoaComponent implements OnInit {
    form: FormGroup;
    submitted = false;
    loading = false;

    constructor(
        private pessoaService: PessoaService,
        private formBuilder: FormBuilder,
        private router: Router) {
    }

    ngOnInit() {
        this.form = this.formBuilder.group({
            nome: ['', Validators.required],
            email: ['', [Validators.required, Validators.email]],
        });
    }

    get f() {
        return this.form.controls;
    }

    onSubmit() {
        this.submitted = true;
        if (this.form.invalid) {
            return;
        }
        this.pessoaService.addPessoa(this.form.value).subscribe((res: Pessoa) => {
                alert(res.nome + " cadastrado com Sucesso!");
                this.router.navigate(['/']).then();
            },
            error => {
                console.log(error)
            }
        );
    }

}
