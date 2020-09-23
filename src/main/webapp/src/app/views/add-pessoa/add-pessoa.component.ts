import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
    selector: 'app-add-pessoa',
    templateUrl: './add-pessoa.component.html',
    styleUrls: ['./add-pessoa.component.css']
})
export class AddPessoaComponent implements OnInit {
    id: number = 0;

    constructor(
        private route: ActivatedRoute,
    ) {
    }

    ngOnInit() {
        this.route.queryParams.subscribe(params => {
            this.id = params['id'];
        });
    }

}
